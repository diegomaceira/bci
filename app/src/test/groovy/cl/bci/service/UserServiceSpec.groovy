package cl.bci.service

import cl.bci.dto.TelephoneDTO
import cl.bci.dto.UserDTO
import cl.bci.mapper.UserMapper
import cl.bci.model.Telephone
import cl.bci.model.User
import cl.bci.repository.UserRepository
import cl.bci.security.JwtTokenUtil
import spock.lang.Specification


class UserServiceSpec extends Specification{

    def service
    def userRepository = Mock(UserRepository)
    def jwtTokenUtil = Mock(JwtTokenUtil)
    def userMapper = Mock(UserMapper)

    def setup(){

        service = new UserService(
                userRepository,
                jwtTokenUtil,
                userMapper
        )
    }

    def "Ejecucion metodo obtener usuario por id"(){

        given: "La siguiente configuracion"
        Set<Telephone> telephones = new ArrayList<>();
        telephones.add(new Telephone(1,1234,1,"ARG"))
        User userModel = new User(1,"diego","diego@maceira.com","Password123",telephones)

        Set<TelephoneDTO> telephonesDto = new ArrayList<>();
        telephonesDto.add(new TelephoneDTO(1,1234,1,"ARG"))
        UserDTO userDto = new UserDTO(1,"diego","diego@maceira.com","Password123",telephonesDto)

        userRepository.findById(1) >> userModel
        userMapper.convertUserToUserDTO(userModel) >> userDto

        when: "se ejecuta getUserById"
        def respuesta = service.getUserById(1)

        then: "Se obtiene mensaje de status ok"
        assert respuesta != null
    }

    def "Ejecucion metodo save usuario"(){

        given: "La siguiente configuracion"
        Set<TelephoneDTO> telephonesDto = new ArrayList<>();
        telephonesDto.add(new TelephoneDTO(1,1234,1,"ARG"))
        UserDTO userDto = new UserDTO(1,"diego","diego@maceira.com","asd2fq1weDr",telephonesDto)

        when: "se ejecuta save"
        def respuesta = service.save(userDto)

        then: "Se obtiene mensaje de status ok"
        assert respuesta != null
    }

}
