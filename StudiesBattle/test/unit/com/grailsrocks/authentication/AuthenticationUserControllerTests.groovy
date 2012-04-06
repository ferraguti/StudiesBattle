package com.grailsrocks.authentication



import org.junit.*
import grails.test.mixin.*

@TestFor(AuthenticationUserController)
@Mock(AuthenticationUser)
class AuthenticationUserControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/authenticationUser/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.authenticationUserInstanceList.size() == 0
        assert model.authenticationUserInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.authenticationUserInstance != null
    }

    void testSave() {
        controller.save()

        assert model.authenticationUserInstance != null
        assert view == '/authenticationUser/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/authenticationUser/show/1'
        assert controller.flash.message != null
        assert AuthenticationUser.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/authenticationUser/list'


        populateValidParams(params)
        def authenticationUser = new AuthenticationUser(params)

        assert authenticationUser.save() != null

        params.id = authenticationUser.id

        def model = controller.show()

        assert model.authenticationUserInstance == authenticationUser
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/authenticationUser/list'


        populateValidParams(params)
        def authenticationUser = new AuthenticationUser(params)

        assert authenticationUser.save() != null

        params.id = authenticationUser.id

        def model = controller.edit()

        assert model.authenticationUserInstance == authenticationUser
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/authenticationUser/list'

        response.reset()


        populateValidParams(params)
        def authenticationUser = new AuthenticationUser(params)

        assert authenticationUser.save() != null

        // test invalid parameters in update
        params.id = authenticationUser.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/authenticationUser/edit"
        assert model.authenticationUserInstance != null

        authenticationUser.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/authenticationUser/show/$authenticationUser.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        authenticationUser.clearErrors()

        populateValidParams(params)
        params.id = authenticationUser.id
        params.version = -1
        controller.update()

        assert view == "/authenticationUser/edit"
        assert model.authenticationUserInstance != null
        assert model.authenticationUserInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/authenticationUser/list'

        response.reset()

        populateValidParams(params)
        def authenticationUser = new AuthenticationUser(params)

        assert authenticationUser.save() != null
        assert AuthenticationUser.count() == 1

        params.id = authenticationUser.id

        controller.delete()

        assert AuthenticationUser.count() == 0
        assert AuthenticationUser.get(authenticationUser.id) == null
        assert response.redirectedUrl == '/authenticationUser/list'
    }
}
