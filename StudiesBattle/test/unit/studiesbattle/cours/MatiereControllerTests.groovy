package studiesbattle.cours



import org.junit.*
import grails.test.mixin.*

@TestFor(MatiereController)
@Mock(Matiere)
class MatiereControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/matiere/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.matiereInstanceList.size() == 0
        assert model.matiereInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.matiereInstance != null
    }

    void testSave() {
        controller.save()

        assert model.matiereInstance != null
        assert view == '/matiere/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/matiere/show/1'
        assert controller.flash.message != null
        assert Matiere.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/matiere/list'


        populateValidParams(params)
        def matiere = new Matiere(params)

        assert matiere.save() != null

        params.id = matiere.id

        def model = controller.show()

        assert model.matiereInstance == matiere
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/matiere/list'


        populateValidParams(params)
        def matiere = new Matiere(params)

        assert matiere.save() != null

        params.id = matiere.id

        def model = controller.edit()

        assert model.matiereInstance == matiere
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/matiere/list'

        response.reset()


        populateValidParams(params)
        def matiere = new Matiere(params)

        assert matiere.save() != null

        // test invalid parameters in update
        params.id = matiere.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/matiere/edit"
        assert model.matiereInstance != null

        matiere.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/matiere/show/$matiere.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        matiere.clearErrors()

        populateValidParams(params)
        params.id = matiere.id
        params.version = -1
        controller.update()

        assert view == "/matiere/edit"
        assert model.matiereInstance != null
        assert model.matiereInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/matiere/list'

        response.reset()

        populateValidParams(params)
        def matiere = new Matiere(params)

        assert matiere.save() != null
        assert Matiere.count() == 1

        params.id = matiere.id

        controller.delete()

        assert Matiere.count() == 0
        assert Matiere.get(matiere.id) == null
        assert response.redirectedUrl == '/matiere/list'
    }
}
