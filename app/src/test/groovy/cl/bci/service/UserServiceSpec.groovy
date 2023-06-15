package cl.bci.service

import cl.bci.dto.ErrorDTO
import cl.bci.dto.TelephoneDTO
import cl.bci.dto.UserDTO
import cl.bci.mapper.UserMapper
import cl.bci.model.Telephone
import cl.bci.model.User
import cl.bci.repository.UserRepository
import cl.bci.security.JwtTokenUtil
import spock.lang.Specification

import java.text.SimpleDateFormat


class UserServiceSpec extends Specification {

    def service
    def userRepository = Mock(UserRepository)
    def jwtTokenUtil = Mock(JwtTokenUtil)
    def userMapper = Mock(UserMapper)

    def setup() {

        service = new UserServiceImpl(
                userRepository,
                jwtTokenUtil,
                userMapper
        )
    }

    def "Ejecucion metodo obtener usuario por id"() {

        given: "La siguiente configuracion"
        Set<Telephone> telephones = new ArrayList<>()
        telephones.add(new Telephone(1, 1234, 1, "ARG"))
        User userModel = User.builder().id(1).name("diego").email("diego@maceira.com").password("Password123").phones(telephones).build()

        Set<TelephoneDTO> telephonesDto = new ArrayList<>()
        telephonesDto.add(new TelephoneDTO(1, 1234, 1, "ARG"))
        UserDTO userDto = UserDTO.builder().id(1).name("diego").email("diego@maceira.com").password("asd2fq1weDr").phones(telephonesDto).build()

        userRepository.findById(1) >> userModel
        userMapper.convertUserToUserDTO(userModel) >> userDto

        when: "se ejecuta getUserById"
        def respuesta = service.getUserById(1)

        then: "Se obtiene mensaje de status ok"
        assert respuesta != null
    }

    def "Ejecucion metodo save usuario"() {

        given: "La siguiente configuracion"
        Set<TelephoneDTO> telephonesDto = new ArrayList<>()
        telephonesDto.add(new TelephoneDTO(1, 1234, 1, "ARG"))
        UserDTO userDto = UserDTO.builder().id(1).name("diego").email("diego@maceira.com").password("asd2fq1weDr").phones(telephonesDto).build()

        when: "se ejecuta save"
        def respuesta = service.save(userDto)

        then: "Se obtiene mensaje de status ok"
        assert respuesta != null
    }

    def "Ejecucion metodo validar email"() {

        given: "La siguiente configuracion"
        ErrorDTO error = new ErrorDTO()
        String formatedDate = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a").format(new Date())

        when: "se ejecuta validateEmail"
        def respuesta = service.validateEmail(error.getErrorDetail(), "diego@maceira.com", formatedDate)

        then: "Si la lista de errores tiene 0 errores es que el mail era valido"
        assert error.getErrorDetail().size() == 0
    }

    def "Ejecucion metodo validar password"() {

        given: "La siguiente configuracion"
        ErrorDTO error = new ErrorDTO()
        String formatedDate = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a").format(new Date())

        when: "se ejecuta validatePassword"
        def respuesta = service.validatePassword(error.getErrorDetail(), "asd2fq1weDr", formatedDate)

        then: "Si la lista de errores tiene 0 errores es que el mail era valido"
        assert error.getErrorDetail().size() == 0
    }

}
