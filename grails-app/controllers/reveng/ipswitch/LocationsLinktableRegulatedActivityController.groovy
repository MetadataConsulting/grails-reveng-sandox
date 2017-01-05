package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LocationsLinktableRegulatedActivityController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LocationsLinktableRegulatedActivity.list(params), model:[locationsLinktableRegulatedActivityCount: LocationsLinktableRegulatedActivity.count()]
    }

    def show(LocationsLinktableRegulatedActivity locationsLinktableRegulatedActivity) {
        respond locationsLinktableRegulatedActivity
    }

    def create() {
        respond new LocationsLinktableRegulatedActivity(params)
    }

    @Transactional
    def save(LocationsLinktableRegulatedActivity locationsLinktableRegulatedActivity) {
        if (locationsLinktableRegulatedActivity == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableRegulatedActivity.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableRegulatedActivity.errors, view:'create'
            return
        }

        locationsLinktableRegulatedActivity.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationsLinktableRegulatedActivity.label', default: 'LocationsLinktableRegulatedActivity'), locationsLinktableRegulatedActivity.id])
                redirect locationsLinktableRegulatedActivity
            }
            '*' { respond locationsLinktableRegulatedActivity, [status: CREATED] }
        }
    }

    def edit(LocationsLinktableRegulatedActivity locationsLinktableRegulatedActivity) {
        respond locationsLinktableRegulatedActivity
    }

    @Transactional
    def update(LocationsLinktableRegulatedActivity locationsLinktableRegulatedActivity) {
        if (locationsLinktableRegulatedActivity == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (locationsLinktableRegulatedActivity.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond locationsLinktableRegulatedActivity.errors, view:'edit'
            return
        }

        locationsLinktableRegulatedActivity.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'locationsLinktableRegulatedActivity.label', default: 'LocationsLinktableRegulatedActivity'), locationsLinktableRegulatedActivity.id])
                redirect locationsLinktableRegulatedActivity
            }
            '*'{ respond locationsLinktableRegulatedActivity, [status: OK] }
        }
    }

    @Transactional
    def delete(LocationsLinktableRegulatedActivity locationsLinktableRegulatedActivity) {

        if (locationsLinktableRegulatedActivity == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        locationsLinktableRegulatedActivity.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'locationsLinktableRegulatedActivity.label', default: 'LocationsLinktableRegulatedActivity'), locationsLinktableRegulatedActivity.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationsLinktableRegulatedActivity.label', default: 'LocationsLinktableRegulatedActivity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
