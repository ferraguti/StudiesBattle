package studiesbattle.cours

import org.springframework.dao.DataIntegrityViolationException

import studiesbattle.personne.*


class MatiereController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def springSecurityService
	
	def exam(){
		if(springSecurityService.isLoggedIn()){
			def user = springSecurityService.currentUser
			Professeur p = Professeur.findByUsername(user.username)
			
			if(p != null){
				def matiereInstance = Matiere.get(params.id)
				
				if(matiereInstance.getProfesseurs().contains(p)){
					def etudiants = Etudiant.findAllByParcours(matiereInstance.getParcours())
					flash.message = "L'examen c'est deroule avec succes. \r\n"
						
					for(e in etudiants)
						flash.message += e.toString() + " a obtenu une note de " + e.passerExam() + "/20. "
						
				}
				else
					flash.message = "Vous n'etes pas un professeur de cette matiere, vous ne pouvez pas organiser d'examen pour celle-ci"
			}
			else
				flash.message = "Vous n'etes pas un professeur, vous ne pouvez pas organiser d'examen"
	
			redirect(action: "show", id: params.id)
		}
		else {
			flash.message = "Vous n'etes pas identifie"
			redirect(controller: "login", action: "index")
		}
			
	}

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
		
//		ArrayList<Matiere> matieres = matiereInstance.getParcours().getMatieres()
//		matieres.add(matiereInstance)
//		matiereInstance.getParcours().setMatieres(matieres)
		
        if (!matiereInstance.save(flush: true)) {
            render(view: "create", model: [matiereInstance: matiereInstance])
            return
        }
		
		if(matiereInstance.getPage() == null)
			matiereInstance.setPage(new PageMatiere(matiereInstance))
		
		//matiereInstance.getParcours().ajouterMatiere(matiereInstance)
		//matiereInstance.getParcours().addToMatieres(matiereInstance)
			
			
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
