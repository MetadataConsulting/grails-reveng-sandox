package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsLinktableRegulatedActivityContactsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsLinktableRegulatedActivityContacts.list(params), model:[locationsLinktableRegulatedActivityContactsCount: LocationsLinktableRegulatedActivityContacts.count()]
    }

    def show(LocationsLinktableRegulatedActivityContacts locationsLinktableRegulatedActivityContacts) {
        respond locationsLinktableRegulatedActivityContacts
    }

    def create() {
        respond new LocationsLinktableRegulatedActivityContacts(params)
    }

    @Transactional
    def save(LocationsLinktableRegulatedActivityContacts locationsLinktableRegulatedActivityContacts) {
        if (locationsLinktableRegulatedActivityContacts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableRegulatedActivityContacts.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableRegulatedActivityContacts.errors, view:'create'
            return
        }

        locationsLinktableRegulatedActivityContacts.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsLinktableRegulatedActivityContacts.label', default: 'LocationsLinktableRegulatedActivityContacts'), locationsLinktableRegulatedActivityContacts.id])
                redirect locationsLinktableRegulatedActivityContacts
            }
            '*' { respond locationsLinktableRegulatedActivityContacts, [status: CREATED] }
        }
    }

    def edit(LocationsLinktableRegulatedActivityContacts locationsLinktableRegulatedActivityContacts) {
        respond locationsLinktableRegulatedActivityContacts
    }

    @Transactional
    def update(LocationsLinktableRegulatedActivityContacts locationsLinktableRegulatedActivityContacts) {
        if (locationsLinktableRegulatedActivityContacts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableRegulatedActivityContacts.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableRegulatedActivityContacts.errors, view:'edit'
            return
        }

        locationsLinktableRegulatedActivityContacts.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsLinktableRegulatedActivityContacts.label', default: 'LocationsLinktableRegulatedActivityContacts'), locationsLinktableRegulatedActivityContacts.id])
                redirect locationsLinktableRegulatedActivityContacts
            }
            '*'{ respond locationsLinktableRegulatedActivityContacts, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsLinktableRegulatedActivityContacts locationsLinktableRegulatedActivityContacts) {

        if (locationsLinktableRegulatedActivityContacts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsLinktableRegulatedActivityContacts.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsLinktableRegulatedActivityContacts.label', default: 'LocationsLinktableRegulatedActivityContacts'), locationsLinktableRegulatedActivityContacts.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsLinktableRegulatedActivityContacts.label', default: 'LocationsLinktableRegulatedActivityContacts'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
