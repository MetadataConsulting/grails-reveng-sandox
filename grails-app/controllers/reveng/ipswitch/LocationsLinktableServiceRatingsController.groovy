package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsLinktableServiceRatingsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsLinktableServiceRatings.list(params), model:[locationsLinktableServiceRatingsCount: LocationsLinktableServiceRatings.count()]
    }

    def show(LocationsLinktableServiceRatings locationsLinktableServiceRatings) {
        respond locationsLinktableServiceRatings
    }

    def create() {
        respond new LocationsLinktableServiceRatings(params)
    }

    @Transactional
    def save(LocationsLinktableServiceRatings locationsLinktableServiceRatings) {
        if (locationsLinktableServiceRatings == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableServiceRatings.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableServiceRatings.errors, view:'create'
            return
        }

        locationsLinktableServiceRatings.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsLinktableServiceRatings.label', default: 'LocationsLinktableServiceRatings'), locationsLinktableServiceRatings.id])
                redirect locationsLinktableServiceRatings
            }
            '*' { respond locationsLinktableServiceRatings, [status: CREATED] }
        }
    }

    def edit(LocationsLinktableServiceRatings locationsLinktableServiceRatings) {
        respond locationsLinktableServiceRatings
    }

    @Transactional
    def update(LocationsLinktableServiceRatings locationsLinktableServiceRatings) {
        if (locationsLinktableServiceRatings == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableServiceRatings.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableServiceRatings.errors, view:'edit'
            return
        }

        locationsLinktableServiceRatings.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsLinktableServiceRatings.label', default: 'LocationsLinktableServiceRatings'), locationsLinktableServiceRatings.id])
                redirect locationsLinktableServiceRatings
            }
            '*'{ respond locationsLinktableServiceRatings, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsLinktableServiceRatings locationsLinktableServiceRatings) {

        if (locationsLinktableServiceRatings == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsLinktableServiceRatings.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsLinktableServiceRatings.label', default: 'LocationsLinktableServiceRatings'), locationsLinktableServiceRatings.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsLinktableServiceRatings.label', default: 'LocationsLinktableServiceRatings'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
