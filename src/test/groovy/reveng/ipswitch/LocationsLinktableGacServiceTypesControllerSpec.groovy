package reveng.ipswitch

import grails.test.mixin.*
import spock.lang.*

@TestFor(LocationsLinktableGacServiceTypesController)
@Mock(LocationsLinktableGacServiceTypes)
class LocationsLinktableGacServiceTypesControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.locationsLinktableGacServiceTypesList
            model.locationsLinktableGacServiceTypesCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.locationsLinktableGacServiceTypes!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def locationsLinktableGacServiceTypes = new LocationsLinktableGacServiceTypes()
            locationsLinktableGacServiceTypes.validate()
            controller.save(locationsLinktableGacServiceTypes)

        then:"The create view is rendered again with the correct model"
            model.locationsLinktableGacServiceTypes!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            locationsLinktableGacServiceTypes = new LocationsLinktableGacServiceTypes(params)

            controller.save(locationsLinktableGacServiceTypes)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/locationsLinktableGacServiceTypes/show/1'
            controller.flash.message != null
            LocationsLinktableGacServiceTypes.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def locationsLinktableGacServiceTypes = new LocationsLinktableGacServiceTypes(params)
            controller.show(locationsLinktableGacServiceTypes)

        then:"A model is populated containing the domain instance"
            model.locationsLinktableGacServiceTypes == locationsLinktableGacServiceTypes
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def locationsLinktableGacServiceTypes = new LocationsLinktableGacServiceTypes(params)
            controller.edit(locationsLinktableGacServiceTypes)

        then:"A model is populated containing the domain instance"
            model.locationsLinktableGacServiceTypes == locationsLinktableGacServiceTypes
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/locationsLinktableGacServiceTypes/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def locationsLinktableGacServiceTypes = new LocationsLinktableGacServiceTypes()
            locationsLinktableGacServiceTypes.validate()
            controller.update(locationsLinktableGacServiceTypes)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.locationsLinktableGacServiceTypes == locationsLinktableGacServiceTypes

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            locationsLinktableGacServiceTypes = new LocationsLinktableGacServiceTypes(params).save(flush: true)
            controller.update(locationsLinktableGacServiceTypes)

        then:"A redirect is issued to the show action"
            locationsLinktableGacServiceTypes != null
            response.redirectedUrl == "/locationsLinktableGacServiceTypes/show/$locationsLinktableGacServiceTypes.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/locationsLinktableGacServiceTypes/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def locationsLinktableGacServiceTypes = new LocationsLinktableGacServiceTypes(params).save(flush: true)

        then:"It exists"
            LocationsLinktableGacServiceTypes.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(locationsLinktableGacServiceTypes)

        then:"The instance is deleted"
            LocationsLinktableGacServiceTypes.count() == 0
            response.redirectedUrl == '/locationsLinktableGacServiceTypes/index'
            flash.message != null
    }
}
