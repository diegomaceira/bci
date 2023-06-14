package cl.bci.controller

import cl.bci.dto.TelephoneDTO
import cl.bci.dto.UserDTO
import cl.bci.model.User
import cl.bci.service.UserServiceImpl
import spock.lang.Specification

class UserControllerSpec extends Specification{

    def controller
    def userService

    def setup(){
        userService = Mock(UserServiceImpl)
        controller = new UserController(userService)
    }

    def "Ejecucion endpoint /login"(){

        given: "La siguiente configuracion"
        List<UserDTO> users = new ArrayList<>();
        Set<TelephoneDTO> telephones = new ArrayList<>();
        telephones.add("1234-5678")
        UserDTO userDto = UserDTO.builder().name("diego").email("diego@maceira.com").password("Password123").phones(telephones).build();
        users.add(userDto)

        userService.getAllUser() >> users

        when: "se ejecuta getAllUsers"
        def respuesta = controller.getAllUsers()

        then: "Se obtiene mensaje de status ok"
        assert respuesta.getStatusCodeValue() == 200
    }

    def "Ejecucion endpoint /login/{id}"(){

        given: "La siguiente configuracion"
        Set<TelephoneDTO> telephones = new ArrayList<>();
        telephones.add("1234-5678")
        UserDTO userDto = UserDTO.builder().name("diego").email("diego@maceira.com").password("Password123").phones(telephones).build();

        userService.getUserById(1) >> userDto

        when: "se ejecuta getUser"
        def respuesta = controller.getUser(1)

        then: "Se obtiene mensaje de status ok"
        assert respuesta.getStatusCodeValue() == 200
    }

    def "Ejecucion endpoint /sign-up"(){

        given: "La siguiente configuracion"
        Set<TelephoneDTO> telephones = new ArrayList<>();
        telephones.add("1234-5678")
        UserDTO user = UserDTO.builder().name("diego").email("diego@maceira.com").password("Password123").phones(telephones).build();

        userService.save(_) >> user

        when: "se ejecuta saveUser"
        def respuesta = controller.saveUser(user)

        then: "Se obtiene mensaje de status ok"
        assert respuesta.getStatusCodeValue() == 200
    }

}
