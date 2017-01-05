package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsLinktableSpecialismsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsLinktableSpecialisms.list(params), model:[locationsLinktableSpecialismsCount: LocationsLinktableSpecialisms.count()]
    }

    def show(LocationsLinktableSpecialisms locationsLinktableSpecialisms) {
        respond locationsLinktableSpecialisms
    }

    def create() {
        respond new LocationsLinktableSpecialisms(params)
    }

    @Transactional
    def save(LocationsLinktableSpecialisms locationsLinktableSpecialisms) {
        if (locationsLinktableSpecialisms == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableSpecialisms.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableSpecialisms.errors, view:'create'
            return
        }

        locationsLinktableSpecialisms.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsLinktableSpecialisms.label', default: 'LocationsLinktableSpecialisms'), locationsLinktableSpecialisms.id])
                redirect locationsLinktableSpecialisms
            }
            '*' { respond locationsLinktableSpecialisms, [status: CREATED] }
        }
    }

    def edit(LocationsLinktableSpecialisms locationsLinktableSpecialisms) {
        respond locationsLinktableSpecialisms
    }

    @Transactional
    def update(LocationsLinktableSpecialisms locationsLinktableSpecialisms) {
        if (locationsLinktableSpecialisms == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableSpecialisms.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableSpecialisms.errors, view:'edit'
            return
        }

        locationsLinktableSpecialisms.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsLinktableSpecialisms.label', default: 'LocationsLinktableSpecialisms'), locationsLinktableSpecialisms.id])
                redirect locationsLinktableSpecialisms
            }
            '*'{ respond locationsLinktableSpecialisms, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsLinktableSpecialisms locationsLinktableSpecialisms) {

        if (locationsLinktableSpecialisms == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsLinktableSpecialisms.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsLinktableSpecialisms.label', default: 'LocationsLinktableSpecialisms'), locationsLinktableSpecialisms.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsLinktableSpecialisms.label', default: 'LocationsLinktableSpecialisms'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
