package navigation

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.core.GrailsApplication
import grails.plugins.*
import groovy.transform.CompileDynamic

@Secured(['ROLE_ADMIN','ROLE_USER'])
class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager
    SpringSecurityService springSecurityService


    @Secured(['ROLE_USER'])
    def index() {
        loggedUsername()
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }


    @CompileDynamic
    protected void loggedUsername() {
        println(springSecurityService.principal)
        println(springSecurityService.principal.username)
        println(springSecurityService.principal.authorities)
    }
}
