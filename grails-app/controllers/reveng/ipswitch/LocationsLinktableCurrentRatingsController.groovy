package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsLinktableCurrentRatingsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsLinktableCurrentRatings.list(params), model:[locationsLinktableCurrentRatingsCount: LocationsLinktableCurrentRatings.count()]
    }

    def show(LocationsLinktableCurrentRatings locationsLinktableCurrentRatings) {
        respond locationsLinktableCurrentRatings
    }

    def create() {
        respond new LocationsLinktableCurrentRatings(params)
    }

    @Transactional
    def save(LocationsLinktableCurrentRatings locationsLinktableCurrentRatings) {
        if (locationsLinktableCurrentRatings == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableCurrentRatings.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableCurrentRatings.errors, view:'create'
            return
        }

        locationsLinktableCurrentRatings.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsLinktableCurrentRatings.label', default: 'LocationsLinktableCurrentRatings'), locationsLinktableCurrentRatings.id])
                redirect locationsLinktableCurrentRatings
            }
            '*' { respond locationsLinktableCurrentRatings, [status: CREATED] }
        }
    }

    def edit(LocationsLinktableCurrentRatings locationsLinktableCurrentRatings) {
        respond locationsLinktableCurrentRatings
    }

    @Transactional
    def update(LocationsLinktableCurrentRatings locationsLinktableCurrentRatings) {
        if (locationsLinktableCurrentRatings == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableCurrentRatings.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableCurrentRatings.errors, view:'edit'
            return
        }

        locationsLinktableCurrentRatings.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsLinktableCurrentRatings.label', default: 'LocationsLinktableCurrentRatings'), locationsLinktableCurrentRatings.id])
                redirect locationsLinktableCurrentRatings
            }
            '*'{ respond locationsLinktableCurrentRatings, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsLinktableCurrentRatings locationsLinktableCurrentRatings) {

        if (locationsLinktableCurrentRatings == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsLinktableCurrentRatings.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsLinktableCurrentRatings.label', default: 'LocationsLinktableCurrentRatings'), locationsLinktableCurrentRatings.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsLinktableCurrentRatings.label', default: 'LocationsLinktableCurrentRatings'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
