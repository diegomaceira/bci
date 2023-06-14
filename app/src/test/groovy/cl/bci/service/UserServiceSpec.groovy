package cl.bci.service

import cl.bci.mapper.UserMapper
import cl.bci.repository.UserRepository
import cl.bci.security.JwtTokenUtil
import spock.lang.Specification

class UserServiceSpec extends Specification{

    def service
    def userRepository
    def jwtTokenUtil
    def userMapper

    def setup(){
        userRepository = Mock(UserRepository)
        jwtTokenUtil = Mock(JwtTokenUtil)
        userMapper = Mock(UserMapper)
        service = new UserService(
                userRepository,
                jwtTokenUtil,
                userMapper
        )
    }


}
