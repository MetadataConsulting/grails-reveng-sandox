package reveng.ipswitch

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CqcDirectoryScdController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CqcDirectoryScd.list(params), model:[cqcDirectoryScdCount: CqcDirectoryScd.count()]
    }

    def show(CqcDirectoryScd cqcDirectoryScd) {
        respond cqcDirectoryScd
    }

    def create() {
        respond new CqcDirectoryScd(params)
    }

    @Transactional
    def save(CqcDirectoryScd cqcDirectoryScd) {
        if (cqcDirectoryScd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cqcDirectoryScd.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cqcDirectoryScd.errors, view:'create'
            return
        }

        cqcDirectoryScd.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cqcDirectoryScd.label', default: 'CqcDirectoryScd'), cqcDirectoryScd.id])
                redirect cqcDirectoryScd
            }
            '*' { respond cqcDirectoryScd, [status: CREATED] }
        }
    }

    def edit(CqcDirectoryScd cqcDirectoryScd) {
        respond cqcDirectoryScd
    }

    @Transactional
    def update(CqcDirectoryScd cqcDirectoryScd) {
        if (cqcDirectoryScd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cqcDirectoryScd.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cqcDirectoryScd.errors, view:'edit'
            return
        }

        cqcDirectoryScd.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cqcDirectoryScd.label', default: 'CqcDirectoryScd'), cqcDirectoryScd.id])
                redirect cqcDirectoryScd
            }
            '*'{ respond cqcDirectoryScd, [status: OK] }
        }
    }

    @Transactional
    def delete(CqcDirectoryScd cqcDirectoryScd) {

        if (cqcDirectoryScd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cqcDirectoryScd.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cqcDirectoryScd.label', default: 'CqcDirectoryScd'), cqcDirectoryScd.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cqcDirectoryScd.label', default: 'CqcDirectoryScd'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
