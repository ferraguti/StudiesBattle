package com.grailsrocks.authentication

import org.springframework.dao.DataIntegrityViolationException

class AuthenticationUserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [authenticationUserInstanceList: AuthenticationUser.list(params), authenticationUserInstanceTotal: AuthenticationUser.count()]
    }

    def create() {
        [authenticationUserInstance: new AuthenticationUser(params)]
    }

    def save() {
        def authenticationUserInstance = new AuthenticationUser(params)
        if (!authenticationUserInstance.save(flush: true)) {
            render(view: "create", model: [authenticationUserInstance: authenticationUserInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'authenticationUser.label', default: 'AuthenticationUser'), authenticationUserInstance.id])
        redirect(action: "show", id: authenticationUserInstance.id)
    }

    def show() {
        def authenticationUserInstance = AuthenticationUser.get(params.id)
        if (!authenticationUserInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'authenticationUser.label', default: 'AuthenticationUser'), params.id])
            redirect(action: "list")
            return
        }

        [authenticationUserInstance: authenticationUserInstance]
    }

    def edit() {
        def authenticationUserInstance = AuthenticationUser.get(params.id)
        if (!authenticationUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'authenticationUser.label', default: 'AuthenticationUser'), params.id])
            redirect(action: "list")
            return
        }

        [authenticationUserInstance: authenticationUserInstance]
    }

    def update() {
        def authenticationUserInstance = AuthenticationUser.get(params.id)
        if (!authenticationUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'authenticationUser.label', default: 'AuthenticationUser'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (authenticationUserInstance.version > version) {
                authenticationUserInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'authenticationUser.label', default: 'AuthenticationUser')] as Object[],
                          "Another user has updated this AuthenticationUser while you were editing")
                render(view: "edit", model: [authenticationUserInstance: authenticationUserInstance])
                return
            }
        }

        authenticationUserInstance.properties = params

        if (!authenticationUserInstance.save(flush: true)) {
            render(view: "edit", model: [authenticationUserInstance: authenticationUserInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'authenticationUser.label', default: 'AuthenticationUser'), authenticationUserInstance.id])
        redirect(action: "show", id: authenticationUserInstance.id)
    }

    def delete() {
        def authenticationUserInstance = AuthenticationUser.get(params.id)
        if (!authenticationUserInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'authenticationUser.label', default: 'AuthenticationUser'), params.id])
            redirect(action: "list")
            return
        }

        try {
            authenticationUserInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'authenticationUser.label', default: 'AuthenticationUser'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'authenticationUser.label', default: 'AuthenticationUser'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
