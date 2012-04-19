package studiesbattle.personne

import org.springframework.dao.DataIntegrityViolationException

class MurController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [murInstanceList: Mur.list(params), murInstanceTotal: Mur.count()]
    }

    def create() {
        [murInstance: new Mur(params)]
    }

    def save() {
        def murInstance = new Mur(params)
        if (!murInstance.save(flush: true)) {
            render(view: "create", model: [murInstance: murInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'mur.label', default: 'Mur'), murInstance.id])
        redirect(action: "show", id: murInstance.id)
    }

    def show() {
        def murInstance = Mur.get(params.id)
        if (!murInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'mur.label', default: 'Mur'), params.id])
            redirect(action: "list")
            return
        }
		
		System.out.println(murInstance.posts.size())

        [murInstance: murInstance]
    }

    def edit() {
        def murInstance = Mur.get(params.id)
        if (!murInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mur.label', default: 'Mur'), params.id])
            redirect(action: "list")
            return
        }

        [murInstance: murInstance]
    }

    def update() {
        def murInstance = Mur.get(params.id)
        if (!murInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mur.label', default: 'Mur'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (murInstance.version > version) {
                murInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'mur.label', default: 'Mur')] as Object[],
                          "Another user has updated this Mur while you were editing")
                render(view: "edit", model: [murInstance: murInstance])
                return
            }
        }

        murInstance.properties = params

        if (!murInstance.save(flush: true)) {
            render(view: "edit", model: [murInstance: murInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'mur.label', default: 'Mur'), murInstance.id])
        redirect(action: "show", id: murInstance.id)
    }

    def delete() {
        def murInstance = Mur.get(params.id)
        if (!murInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'mur.label', default: 'Mur'), params.id])
            redirect(action: "list")
            return
        }

        try {
            murInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'mur.label', default: 'Mur'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'mur.label', default: 'Mur'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def poster(){
		def murInstance = Mur.get(params.id)
		
		//ici recuperer username
		String username = new String("RAT")
		
		murInstance.posts.add("RANDOM MESSAGE2")
		murInstance.getPosts().add("RANDOM MESSAGE3")
		murInstance.poster("RANDOM MESSAGE1", username)
		
		System.out.println(murInstance.posts.size())
		redirect(action: "show", id: murInstance.id)
	}
}
