package studiesbattle.personne



import org.junit.*
import grails.test.mixin.*

@TestFor(PersonneController)
@Mock(Personne)
class PersonneControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/personne/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personneInstanceList.size() == 0
        assert model.personneInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.personneInstance != null
    }

    void testSave() {
        controller.save()

        assert model.personneInstance != null
        assert view == '/personne/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/personne/show/1'
        assert controller.flash.message != null
        assert Personne.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/personne/list'


        populateValidParams(params)
        def personne = new Personne(params)

        assert personne.save() != null

        params.id = personne.id

        def model = controller.show()

        assert model.personneInstance == personne
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/personne/list'


        populateValidParams(params)
        def personne = new Personne(params)

        assert personne.save() != null

        params.id = personne.id

        def model = controller.edit()

        assert model.personneInstance == personne
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/personne/list'

        response.reset()


        populateValidParams(params)
        def personne = new Personne(params)

        assert personne.save() != null

        // test invalid parameters in update
        params.id = personne.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/personne/edit"
        assert model.personneInstance != null

        personne.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/personne/show/$personne.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        personne.clearErrors()

        populateValidParams(params)
        params.id = personne.id
        params.version = -1
        controller.update()

        assert view == "/personne/edit"
        assert model.personneInstance != null
        assert model.personneInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/personne/list'

        response.reset()

        populateValidParams(params)
        def personne = new Personne(params)

        assert personne.save() != null
        assert Personne.count() == 1

        params.id = personne.id

        controller.delete()

        assert Personne.count() == 0
        assert Personne.get(personne.id) == null
        assert response.redirectedUrl == '/personne/list'
    }
}
