package auth

import grails.plugin.springsecurity.annotation.Secured
import grails.core.GrailsApplication
import grails.plugins.*

@Secured(['ROLE_ADMIN','ROLE_USER'])
class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager


    @Secured(['ROLE_ADMIN'])
    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

}
