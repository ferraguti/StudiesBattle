package studiesbattle.cours

import org.springframework.dao.DataIntegrityViolationException

class MatiereController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [matiereInstanceList: Matiere.list(params), matiereInstanceTotal: Matiere.count()]
    }

    def create() {
        [matiereInstance: new Matiere(params)]
    }

    def save() {
        def matiereInstance = new Matiere(params)
        if (!matiereInstance.save(flush: true)) {
            render(view: "create", model: [matiereInstance: matiereInstance])
            return
        }
		
		PageMatiere page = new PageMatiere(matiereInstance)
		matiereInstance.setPage(page)
		
		//matiereInstance.getParcours().ajouterMatiere(matiereInstance)

		flash.message = message(code: 'default.created.message', args: [message(code: 'matiere.label', default: 'Matiere'), matiereInstance.id])
        redirect(action: "show", id: matiereInstance.id)
    }

    def show() {
        def matiereInstance = Matiere.get(params.id)
        if (!matiereInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'matiere.label', default: 'Matiere'), params.id])
            redirect(action: "list")
            return
        }
	
        [matiereInstance: matiereInstance]
    }

    def edit() {
        def matiereInstance = Matiere.get(params.id)
        if (!matiereInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'matiere.label', default: 'Matiere'), params.id])
            redirect(action: "list")
            return
        }

        [matiereInstance: matiereInstance]
    }

    def update() {
        def matiereInstance = Matiere.get(params.id)
        if (!matiereInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'matiere.label', default: 'Matiere'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (matiereInstance.version > version) {
                matiereInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'matiere.label', default: 'Matiere')] as Object[],
                          "Another user has updated this Matiere while you were editing")
                render(view: "edit", model: [matiereInstance: matiereInstance])
                return
            }
        }

        matiereInstance.properties = params

        if (!matiereInstance.save(flush: true)) {
            render(view: "edit", model: [matiereInstance: matiereInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'matiere.label', default: 'Matiere'), matiereInstance.id])
        redirect(action: "show", id: matiereInstance.id)
    }

    def delete() {
        def matiereInstance = Matiere.get(params.id)
        if (!matiereInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'matiere.label', default: 'Matiere'), params.id])
            redirect(action: "list")
            return
        }

        try {
            matiereInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'matiere.label', default: 'Matiere'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'matiere.label', default: 'Matiere'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
