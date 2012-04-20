package studiesbattle.personne

import org.example.UserRole
import org.example.Role
import org.springframework.dao.DataIntegrityViolationException

class ProfesseurController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [professeurInstanceList: Professeur.list(params), professeurInstanceTotal: Professeur.count()]
    }

    def create() {
        [professeurInstance: new Professeur(params)]
		
    }

    def save() {
        def professeurInstance = new Professeur(params)
        if (!professeurInstance.save(flush: true)) {
            render(view: "create", model: [professeurInstance: professeurInstance])
            return
        }
		new UserRole(user: professeurInstance, role: Role.findByAuthority("Professeur")).save(failOnError:true)
		if(professeurInstance.getMur==null)
		professeurInstance.setMur(new Mur(proprietaire: professeurInstance))

		flash.message = message(code: 'default.created.message', args: [message(code: 'professeur.label', default: 'Professeur'), professeurInstance.id])
        redirect(action: "show", id: professeurInstance.id)
    }

    def show() {
        def professeurInstance = Professeur.get(params.id)
        if (!professeurInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'professeur.label', default: 'Professeur'), params.id])
            redirect(action: "list")
            return
        }

        [professeurInstance: professeurInstance]
    }

    def edit() {
        def professeurInstance = Professeur.get(params.id)
        if (!professeurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'professeur.label', default: 'Professeur'), params.id])
            redirect(action: "list")
            return
        }

        [professeurInstance: professeurInstance]
    }

    def update() {
        def professeurInstance = Professeur.get(params.id)
        if (!professeurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'professeur.label', default: 'Professeur'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (professeurInstance.version > version) {
                professeurInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'professeur.label', default: 'Professeur')] as Object[],
                          "Another user has updated this Professeur while you were editing")
                render(view: "edit", model: [professeurInstance: professeurInstance])
                return
            }
        }

        professeurInstance.properties = params

        if (!professeurInstance.save(flush: true)) {
            render(view: "edit", model: [professeurInstance: professeurInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'professeur.label', default: 'Professeur'), professeurInstance.id])
        redirect(action: "show", id: professeurInstance.id)
    }

    def delete() {
        def professeurInstance = Professeur.get(params.id)
        if (!professeurInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'professeur.label', default: 'Professeur'), params.id])
            redirect(action: "list")
            return
        }

        try {
            professeurInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'professeur.label', default: 'Professeur'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'professeur.label', default: 'Professeur'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
