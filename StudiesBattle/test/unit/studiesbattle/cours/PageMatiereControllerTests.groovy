package studiesbattle.cours



import org.junit.*
import grails.test.mixin.*

@TestFor(PageMatiereController)
@Mock(PageMatiere)
class PageMatiereControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pageMatiere/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pageMatiereInstanceList.size() == 0
        assert model.pageMatiereInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.pageMatiereInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pageMatiereInstance != null
        assert view == '/pageMatiere/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pageMatiere/show/1'
        assert controller.flash.message != null
        assert PageMatiere.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pageMatiere/list'


        populateValidParams(params)
        def pageMatiere = new PageMatiere(params)

        assert pageMatiere.save() != null

        params.id = pageMatiere.id

        def model = controller.show()

        assert model.pageMatiereInstance == pageMatiere
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pageMatiere/list'


        populateValidParams(params)
        def pageMatiere = new PageMatiere(params)

        assert pageMatiere.save() != null

        params.id = pageMatiere.id

        def model = controller.edit()

        assert model.pageMatiereInstance == pageMatiere
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pageMatiere/list'

        response.reset()


        populateValidParams(params)
        def pageMatiere = new PageMatiere(params)

        assert pageMatiere.save() != null

        // test invalid parameters in update
        params.id = pageMatiere.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pageMatiere/edit"
        assert model.pageMatiereInstance != null

        pageMatiere.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pageMatiere/show/$pageMatiere.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pageMatiere.clearErrors()

        populateValidParams(params)
        params.id = pageMatiere.id
        params.version = -1
        controller.update()

        assert view == "/pageMatiere/edit"
        assert model.pageMatiereInstance != null
        assert model.pageMatiereInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pageMatiere/list'

        response.reset()

        populateValidParams(params)
        def pageMatiere = new PageMatiere(params)

        assert pageMatiere.save() != null
        assert PageMatiere.count() == 1

        params.id = pageMatiere.id

        controller.delete()

        assert PageMatiere.count() == 0
        assert PageMatiere.get(pageMatiere.id) == null
        assert response.redirectedUrl == '/pageMatiere/list'
    }
}
