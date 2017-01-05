package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsLinktableLocationTypesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsLinktableLocationTypes.list(params), model:[locationsLinktableLocationTypesCount: LocationsLinktableLocationTypes.count()]
    }

    def show(LocationsLinktableLocationTypes locationsLinktableLocationTypes) {
        respond locationsLinktableLocationTypes
    }

    def create() {
        respond new LocationsLinktableLocationTypes(params)
    }

    @Transactional
    def save(LocationsLinktableLocationTypes locationsLinktableLocationTypes) {
        if (locationsLinktableLocationTypes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableLocationTypes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableLocationTypes.errors, view:'create'
            return
        }

        locationsLinktableLocationTypes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsLinktableLocationTypes.label', default: 'LocationsLinktableLocationTypes'), locationsLinktableLocationTypes.id])
                redirect locationsLinktableLocationTypes
            }
            '*' { respond locationsLinktableLocationTypes, [status: CREATED] }
        }
    }

    def edit(LocationsLinktableLocationTypes locationsLinktableLocationTypes) {
        respond locationsLinktableLocationTypes
    }

    @Transactional
    def update(LocationsLinktableLocationTypes locationsLinktableLocationTypes) {
        if (locationsLinktableLocationTypes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableLocationTypes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableLocationTypes.errors, view:'edit'
            return
        }

        locationsLinktableLocationTypes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsLinktableLocationTypes.label', default: 'LocationsLinktableLocationTypes'), locationsLinktableLocationTypes.id])
                redirect locationsLinktableLocationTypes
            }
            '*'{ respond locationsLinktableLocationTypes, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsLinktableLocationTypes locationsLinktableLocationTypes) {

        if (locationsLinktableLocationTypes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsLinktableLocationTypes.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsLinktableLocationTypes.label', default: 'LocationsLinktableLocationTypes'), locationsLinktableLocationTypes.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsLinktableLocationTypes.label', default: 'LocationsLinktableLocationTypes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
