package studiesbattle.cours

import org.springframework.dao.DataIntegrityViolationException

import studiesbattle.personne.Etudiant
import studiesbattle.personne.Professeur

class CoursController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def springSecurityService

	def aller(){
		def coursInstance = Cours.get(params.id)
		System.out.println(coursInstance.matiere)
		
		if(coursInstance.getTermine()){
			flash.message = "Ce cours est deja termine"
			redirect(action: "list")
		}
		else if(springSecurityService.isLoggedIn()){
			def user = springSecurityService.currentUser

			if(Professeur.findByUsername(user.username) == null){ //Alors c'est un etudiant
				Etudiant e = Etudiant.findByUsername(user.username)
				
				if(coursInstance.estPresent(e))
					flash.message = "Vous etes deja present a ce cours"
				else if(coursInstance.getMatiere().getParcours().getNom().equals(e.getParcours().getNom())){
					//coursInstance.getEtudiantsPresents().add(coursInstance)
					coursInstance.addToEtudiantsPresents(e)
					flash.message = "Vous aller a ce cours..."
				}
				else
					flash.message = "Vous etes inscrit dans la parcours " + e.getParcours() + " mais ceci est un cours du parcours " + coursInstance.getMatiere().getParcours() + ", vous ne pouvez donc pas y aller"
					
				redirect(action: "show", id: params.id)
			}
			else{ //Alors c'est un professeur
				Professeur p = coursInstance.getProf()
				
				if(p.getUsername().equals(Professeur.findByUsername(user.username).getUsername())){
					
					ArrayList<Etudiant> etudiantsPresent = coursInstance.getEtudiantsPresents()
					
					for(e in coursInstance.getEtudiantsPresents())
						e.gagnerPoints(coursInstance)
						
					coursInstance.setTermine(true)
					
					flash.message = "Vous avez donne le cours avec succes, il y avait " + coursInstance.getEtudiantsPresents().size() + " eleves presents"
					redirect(action: "list")
				}
				else{
					flash.message = "Vous n'etes pas " + p + ", le professeur attitre a ce cours"
					redirect(action: "show", id: params.id)
				}
			}

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
        [coursInstanceList: Cours.list(params), coursInstanceTotal: Cours.count()]
    }

    def create() {
        [coursInstance: new Cours(params)]
    }

    def save() {
        def coursInstance = new Cours(params)
        if (!coursInstance.save(flush: true)) {
            render(view: "create", model: [coursInstance: coursInstance])
            return
        }
		
		coursInstance.getMatiere().ajouterProfesseur(coursInstance.getProf())

		flash.message = message(code: 'default.created.message', args: [message(code: 'cours.label', default: 'Cours'), coursInstance.id])
        redirect(action: "show", id: coursInstance.id)
    }

    def show() {
        def coursInstance = Cours.get(params.id)
        if (!coursInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'cours.label', default: 'Cours'), params.id])
            redirect(action: "list")
            return
        }

        [coursInstance: coursInstance]
    }

    def edit() {
        def coursInstance = Cours.get(params.id)
        if (!coursInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cours.label', default: 'Cours'), params.id])
            redirect(action: "list")
            return
        }

        [coursInstance: coursInstance]
    }

    def update() {
        def coursInstance = Cours.get(params.id)
        if (!coursInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cours.label', default: 'Cours'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (coursInstance.version > version) {
                coursInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'cours.label', default: 'Cours')] as Object[],
                          "Another user has updated this Cours while you were editing")
                render(view: "edit", model: [coursInstance: coursInstance])
                return
            }
        }

        coursInstance.properties = params

        if (!coursInstance.save(flush: true)) {
            render(view: "edit", model: [coursInstance: coursInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'cours.label', default: 'Cours'), coursInstance.id])
        redirect(action: "show", id: coursInstance.id)
    }

    def delete() {
        def coursInstance = Cours.get(params.id)
        if (!coursInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'cours.label', default: 'Cours'), params.id])
            redirect(action: "list")
            return
        }

        try {
            coursInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'cours.label', default: 'Cours'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'cours.label', default: 'Cours'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
