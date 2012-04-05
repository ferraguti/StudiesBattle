package studiesbattle.cours

import org.springframework.dao.DataIntegrityViolationException

class PageMatiereController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pageMatiereInstanceList: PageMatiere.list(params), pageMatiereInstanceTotal: PageMatiere.count()]
    }

    def create() {
        [pageMatiereInstance: new PageMatiere(params)]
    }

    def save() {
        def pageMatiereInstance = new PageMatiere(params)
        if (!pageMatiereInstance.save(flush: true)) {
            render(view: "create", model: [pageMatiereInstance: pageMatiereInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'pageMatiere.label', default: 'PageMatiere'), pageMatiereInstance.id])
        redirect(action: "show", id: pageMatiereInstance.id)
    }

    def show() {
        def pageMatiereInstance = PageMatiere.get(params.id)
        if (!pageMatiereInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pageMatiere.label', default: 'PageMatiere'), params.id])
            redirect(action: "list")
            return
        }

        [pageMatiereInstance: pageMatiereInstance]
    }

    def edit() {
        def pageMatiereInstance = PageMatiere.get(params.id)
        if (!pageMatiereInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pageMatiere.label', default: 'PageMatiere'), params.id])
            redirect(action: "list")
            return
        }

        [pageMatiereInstance: pageMatiereInstance]
    }

    def update() {
        def pageMatiereInstance = PageMatiere.get(params.id)
        if (!pageMatiereInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pageMatiere.label', default: 'PageMatiere'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (pageMatiereInstance.version > version) {
                pageMatiereInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pageMatiere.label', default: 'PageMatiere')] as Object[],
                          "Another user has updated this PageMatiere while you were editing")
                render(view: "edit", model: [pageMatiereInstance: pageMatiereInstance])
                return
            }
        }

        pageMatiereInstance.properties = params

        if (!pageMatiereInstance.save(flush: true)) {
            render(view: "edit", model: [pageMatiereInstance: pageMatiereInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'pageMatiere.label', default: 'PageMatiere'), pageMatiereInstance.id])
        redirect(action: "show", id: pageMatiereInstance.id)
    }

    def delete() {
        def pageMatiereInstance = PageMatiere.get(params.id)
        if (!pageMatiereInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pageMatiere.label', default: 'PageMatiere'), params.id])
            redirect(action: "list")
            return
        }

        try {
            pageMatiereInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'pageMatiere.label', default: 'PageMatiere'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pageMatiere.label', default: 'PageMatiere'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
