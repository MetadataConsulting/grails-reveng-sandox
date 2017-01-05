package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsLinktableRelationshipsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsLinktableRelationships.list(params), model:[locationsLinktableRelationshipsCount: LocationsLinktableRelationships.count()]
    }

    def show(LocationsLinktableRelationships locationsLinktableRelationships) {
        respond locationsLinktableRelationships
    }

    def create() {
        respond new LocationsLinktableRelationships(params)
    }

    @Transactional
    def save(LocationsLinktableRelationships locationsLinktableRelationships) {
        if (locationsLinktableRelationships == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableRelationships.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableRelationships.errors, view:'create'
            return
        }

        locationsLinktableRelationships.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsLinktableRelationships.label', default: 'LocationsLinktableRelationships'), locationsLinktableRelationships.id])
                redirect locationsLinktableRelationships
            }
            '*' { respond locationsLinktableRelationships, [status: CREATED] }
        }
    }

    def edit(LocationsLinktableRelationships locationsLinktableRelationships) {
        respond locationsLinktableRelationships
    }

    @Transactional
    def update(LocationsLinktableRelationships locationsLinktableRelationships) {
        if (locationsLinktableRelationships == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableRelationships.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableRelationships.errors, view:'edit'
            return
        }

        locationsLinktableRelationships.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsLinktableRelationships.label', default: 'LocationsLinktableRelationships'), locationsLinktableRelationships.id])
                redirect locationsLinktableRelationships
            }
            '*'{ respond locationsLinktableRelationships, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsLinktableRelationships locationsLinktableRelationships) {

        if (locationsLinktableRelationships == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsLinktableRelationships.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsLinktableRelationships.label', default: 'LocationsLinktableRelationships'), locationsLinktableRelationships.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsLinktableRelationships.label', default: 'LocationsLinktableRelationships'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
