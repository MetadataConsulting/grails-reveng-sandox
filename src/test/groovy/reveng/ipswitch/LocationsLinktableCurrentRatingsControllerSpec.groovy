package reveng.ipswitch

import grails.test.mixin.*
import spock.lang.*

@TestFor(LocationsLinktableCurrentRatingsController)
@Mock(LocationsLinktableCurrentRatings)
class LocationsLinktableCurrentRatingsControllerSpec extends Specification {

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
            !model.locationsLinktableCurrentRatingsList
            model.locationsLinktableCurrentRatingsCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.locationsLinktableCurrentRatings!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def locationsLinktableCurrentRatings = new LocationsLinktableCurrentRatings()
            locationsLinktableCurrentRatings.validate()
            controller.save(locationsLinktableCurrentRatings)

        then:"The create view is rendered again with the correct model"
            model.locationsLinktableCurrentRatings!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            locationsLinktableCurrentRatings = new LocationsLinktableCurrentRatings(params)

            controller.save(locationsLinktableCurrentRatings)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/locationsLinktableCurrentRatings/show/1'
            controller.flash.message != null
            LocationsLinktableCurrentRatings.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def locationsLinktableCurrentRatings = new LocationsLinktableCurrentRatings(params)
            controller.show(locationsLinktableCurrentRatings)

        then:"A model is populated containing the domain instance"
            model.locationsLinktableCurrentRatings == locationsLinktableCurrentRatings
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def locationsLinktableCurrentRatings = new LocationsLinktableCurrentRatings(params)
            controller.edit(locationsLinktableCurrentRatings)

        then:"A model is populated containing the domain instance"
            model.locationsLinktableCurrentRatings == locationsLinktableCurrentRatings
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/locationsLinktableCurrentRatings/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def locationsLinktableCurrentRatings = new LocationsLinktableCurrentRatings()
            locationsLinktableCurrentRatings.validate()
            controller.update(locationsLinktableCurrentRatings)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.locationsLinktableCurrentRatings == locationsLinktableCurrentRatings

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            locationsLinktableCurrentRatings = new LocationsLinktableCurrentRatings(params).save(flush: true)
            controller.update(locationsLinktableCurrentRatings)

        then:"A redirect is issued to the show action"
            locationsLinktableCurrentRatings != null
            response.redirectedUrl == "/locationsLinktableCurrentRatings/show/$locationsLinktableCurrentRatings.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/locationsLinktableCurrentRatings/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def locationsLinktableCurrentRatings = new LocationsLinktableCurrentRatings(params).save(flush: true)

        then:"It exists"
            LocationsLinktableCurrentRatings.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(locationsLinktableCurrentRatings)

        then:"The instance is deleted"
            LocationsLinktableCurrentRatings.count() == 0
            response.redirectedUrl == '/locationsLinktableCurrentRatings/index'
            flash.message != null
    }
}
