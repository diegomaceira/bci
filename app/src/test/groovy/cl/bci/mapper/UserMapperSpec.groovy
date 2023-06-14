package cl.bci.mapper

import cl.bci.controller.UserController
import spock.lang.Specification

class UserMapperSpec extends Specification{

    def mapper

    def setup(){
        mapper = new UserMapper()
    }

}
