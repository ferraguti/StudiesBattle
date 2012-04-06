package studiesbattle.cours



import org.junit.*
import grails.test.mixin.*

@TestFor(ParcoursController)
@Mock(Parcours)
class ParcoursControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/parcours/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.parcoursInstanceList.size() == 0
        assert model.parcoursInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.parcoursInstance != null
    }

    void testSave() {
        controller.save()

        assert model.parcoursInstance != null
        assert view == '/parcours/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/parcours/show/1'
        assert controller.flash.message != null
        assert Parcours.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/parcours/list'


        populateValidParams(params)
        def parcours = new Parcours(params)

        assert parcours.save() != null

        params.id = parcours.id

        def model = controller.show()

        assert model.parcoursInstance == parcours
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/parcours/list'


        populateValidParams(params)
        def parcours = new Parcours(params)

        assert parcours.save() != null

        params.id = parcours.id

        def model = controller.edit()

        assert model.parcoursInstance == parcours
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/parcours/list'

        response.reset()


        populateValidParams(params)
        def parcours = new Parcours(params)

        assert parcours.save() != null

        // test invalid parameters in update
        params.id = parcours.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/parcours/edit"
        assert model.parcoursInstance != null

        parcours.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/parcours/show/$parcours.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        parcours.clearErrors()

        populateValidParams(params)
        params.id = parcours.id
        params.version = -1
        controller.update()

        assert view == "/parcours/edit"
        assert model.parcoursInstance != null
        assert model.parcoursInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/parcours/list'

        response.reset()

        populateValidParams(params)
        def parcours = new Parcours(params)

        assert parcours.save() != null
        assert Parcours.count() == 1

        params.id = parcours.id

        controller.delete()

        assert Parcours.count() == 0
        assert Parcours.get(parcours.id) == null
        assert response.redirectedUrl == '/parcours/list'
    }
}
