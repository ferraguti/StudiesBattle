package studiesbattle.cours

import org.springframework.dao.DataIntegrityViolationException

class ParcoursController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [parcoursInstanceList: Parcours.list(params), parcoursInstanceTotal: Parcours.count()]
    }

    def create() {
        [parcoursInstance: new Parcours(params)]
    }

    def save() {

        def parcoursInstance = new Parcours(params)
        if (!parcoursInstance.save(flush: true)) {
            render(view: "create", model: [parcoursInstance: parcoursInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'parcours.label', default: 'Parcours'), parcoursInstance.id])
        redirect(action: "show", id: parcoursInstance.id)
    }

    def show() {
        def parcoursInstance = Parcours.get(params.id)
        if (!parcoursInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'parcours.label', default: 'Parcours'), params.id])
            redirect(action: "list")
            return
        }
		
		System.out.println(Parcours.findByNom("Informatique").getMatieres().size())
		
        [parcoursInstance: parcoursInstance]
    }

    def edit() {
        def parcoursInstance = Parcours.get(params.id)
        if (!parcoursInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'parcours.label', default: 'Parcours'), params.id])
            redirect(action: "list")
            return
        }

        [parcoursInstance: parcoursInstance]
    }

    def update() {
        def parcoursInstance = Parcours.get(params.id)
        if (!parcoursInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'parcours.label', default: 'Parcours'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (parcoursInstance.version > version) {
                parcoursInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'parcours.label', default: 'Parcours')] as Object[],
                          "Another user has updated this Parcours while you were editing")
                render(view: "edit", model: [parcoursInstance: parcoursInstance])
                return
            }
        }

        parcoursInstance.properties = params

        if (!parcoursInstance.save(flush: true)) {
            render(view: "edit", model: [parcoursInstance: parcoursInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'parcours.label', default: 'Parcours'), parcoursInstance.id])
        redirect(action: "show", id: parcoursInstance.id)
    }

    def delete() {
        def parcoursInstance = Parcours.get(params.id)
        if (!parcoursInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'parcours.label', default: 'Parcours'), params.id])
            redirect(action: "list")
            return
        }

        try {
            parcoursInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'parcours.label', default: 'Parcours'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'parcours.label', default: 'Parcours'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
