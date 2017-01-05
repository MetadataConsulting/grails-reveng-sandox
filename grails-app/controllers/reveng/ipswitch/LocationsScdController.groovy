package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsScdController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsScd.list(params), model:[locationsScdCount: LocationsScd.count()]
    }

    def show(LocationsScd locationsScd) {
        respond locationsScd
    }

    def create() {
        respond new LocationsScd(params)
    }

    @Transactional
    def save(LocationsScd locationsScd) {
        if (locationsScd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsScd.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsScd.errors, view:'create'
            return
        }

        locationsScd.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsScd.label', default: 'LocationsScd'), locationsScd.id])
                redirect locationsScd
            }
            '*' { respond locationsScd, [status: CREATED] }
        }
    }

    def edit(LocationsScd locationsScd) {
        respond locationsScd
    }

    @Transactional
    def update(LocationsScd locationsScd) {
        if (locationsScd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsScd.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsScd.errors, view:'edit'
            return
        }

        locationsScd.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsScd.label', default: 'LocationsScd'), locationsScd.id])
                redirect locationsScd
            }
            '*'{ respond locationsScd, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsScd locationsScd) {

        if (locationsScd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsScd.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsScd.label', default: 'LocationsScd'), locationsScd.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsScd.label', default: 'LocationsScd'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
