package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsLinktableGacServiceTypesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsLinktableGacServiceTypes.list(params), model:[locationsLinktableGacServiceTypesCount: LocationsLinktableGacServiceTypes.count()]
    }

    def show(LocationsLinktableGacServiceTypes locationsLinktableGacServiceTypes) {
        respond locationsLinktableGacServiceTypes
    }

    def create() {
        respond new LocationsLinktableGacServiceTypes(params)
    }

    @Transactional
    def save(LocationsLinktableGacServiceTypes locationsLinktableGacServiceTypes) {
        if (locationsLinktableGacServiceTypes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableGacServiceTypes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableGacServiceTypes.errors, view:'create'
            return
        }

        locationsLinktableGacServiceTypes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsLinktableGacServiceTypes.label', default: 'LocationsLinktableGacServiceTypes'), locationsLinktableGacServiceTypes.id])
                redirect locationsLinktableGacServiceTypes
            }
            '*' { respond locationsLinktableGacServiceTypes, [status: CREATED] }
        }
    }

    def edit(LocationsLinktableGacServiceTypes locationsLinktableGacServiceTypes) {
        respond locationsLinktableGacServiceTypes
    }

    @Transactional
    def update(LocationsLinktableGacServiceTypes locationsLinktableGacServiceTypes) {
        if (locationsLinktableGacServiceTypes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableGacServiceTypes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableGacServiceTypes.errors, view:'edit'
            return
        }

        locationsLinktableGacServiceTypes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsLinktableGacServiceTypes.label', default: 'LocationsLinktableGacServiceTypes'), locationsLinktableGacServiceTypes.id])
                redirect locationsLinktableGacServiceTypes
            }
            '*'{ respond locationsLinktableGacServiceTypes, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsLinktableGacServiceTypes locationsLinktableGacServiceTypes) {

        if (locationsLinktableGacServiceTypes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsLinktableGacServiceTypes.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsLinktableGacServiceTypes.label', default: 'LocationsLinktableGacServiceTypes'), locationsLinktableGacServiceTypes.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsLinktableGacServiceTypes.label', default: 'LocationsLinktableGacServiceTypes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
