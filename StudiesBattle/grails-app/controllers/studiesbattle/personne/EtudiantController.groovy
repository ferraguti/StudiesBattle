package studiesbattle.personne

import org.example.UserRole
import org.example.Role
import org.springframework.dao.DataIntegrityViolationException

class EtudiantController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [etudiantInstanceList: Etudiant.list(params), etudiantInstanceTotal: Etudiant.count()]
    }

    def create() {
        [etudiantInstance: new Etudiant(params)]
    }

    def save() {
        def etudiantInstance = new Etudiant(params)
        if (!etudiantInstance.save(flush: true)) {
            render(view: "create", model: [etudiantInstance: etudiantInstance])
            return
        }

		new UserRole(user: etudiantInstance, role: Role.findByAuthority("Etudiant")).save(failOnError:true)
		
		if(etudiantInstance.getMur() == null)
			etudiantInstance.setMur(new Mur(etudiantInstance))
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), etudiantInstance.id])
        redirect(action: "show", id: etudiantInstance.id)
    }

    def show() {
        def etudiantInstance = Etudiant.get(params.id)
        if (!etudiantInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), params.id])
            redirect(action: "list")
            return
        }

        [etudiantInstance: etudiantInstance]
    }

    def edit() {
        def etudiantInstance = Etudiant.get(params.id)
        if (!etudiantInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), params.id])
            redirect(action: "list")
            return
        }

        [etudiantInstance: etudiantInstance]
    }

    def update() {
        def etudiantInstance = Etudiant.get(params.id)
        if (!etudiantInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (etudiantInstance.version > version) {
                etudiantInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'etudiant.label', default: 'Etudiant')] as Object[],
                          "Another user has updated this Etudiant while you were editing")
                render(view: "edit", model: [etudiantInstance: etudiantInstance])
                return
            }
        }

        etudiantInstance.properties = params

        if (!etudiantInstance.save(flush: true)) {
            render(view: "edit", model: [etudiantInstance: etudiantInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), etudiantInstance.id])
        redirect(action: "show", id: etudiantInstance.id)
    }

    def delete() {
        def etudiantInstance = Etudiant.get(params.id)
        if (!etudiantInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), params.id])
            redirect(action: "list")
            return
        }

        try {
            etudiantInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
