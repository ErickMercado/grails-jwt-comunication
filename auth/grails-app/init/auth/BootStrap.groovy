package auth

import mx.eliiot.Role
import mx.eliiot.User
import mx.eliiot.UserRole

class BootStrap {

    def init = { servletContext ->
        Role roleA = new Role(authority: "ROLE_ADMIN").save(failOnError:true)
        Role roleU = new Role(authority: "ROLE_USER").save(failOnError:true)
        User userA = new User(username:"admin@e.com",password:"test123").save(failOnError:true)
        User userU = new User(username:"user@e.com",password:"test123").save(failOnError:true)
        new UserRole(user:userA, role:roleA).save(failOnError:true)
        new UserRole(user:userU, role:roleU).save(failOnError:true)
        //UserRole.create userA, roleA
        //UserRole.create userU, roleU
    }
    def destroy = {
    }
}
