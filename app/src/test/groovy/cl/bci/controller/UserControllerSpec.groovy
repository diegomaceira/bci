package cl.bci.controller

import cl.bci.dto.UserDTO
import cl.bci.model.Telephone
import cl.bci.service.UserService
import spock.lang.Specification

class UserControllerSpec extends Specification{

    def controller
    def userService

    def setup(){
        userService = Mock(UserService)
        controller = new UserController(userService)
    }

    def "Ejecucion endpoint /login"(){

        given: "La siguiente configuracion"
        List<UserDTO> users = new ArrayList<>();
        Set<Telephone> telephones = new ArrayList<>();
        telephones.add("1234-5678")
        users.add(new UserDTO("diego","diego@maceira.com","Password123",telephones))

        userService.getAllUser() >> users

        when: "se ejecuta getAllUsers"
        def respuesta = controller.getAllUsers()

        then: "Se obtiene mensaje de status ok"
        assert respuesta.getStatusCodeValue() == 200
    }

    def "Ejecucion endpoint /login/{id}"(){

        given: "La siguiente configuracion"
        Set<Telephone> telephones = new ArrayList<>();
        telephones.add("1234-5678")
        UserDTO user = new UserDTO(1,"diego","diego@maceira.com","Password123",telephones)

        userService.getUserById(1) >> user

        when: "se ejecuta getUser"
        def respuesta = controller.getUser(1)

        then: "Se obtiene mensaje de status ok"
        assert respuesta.getStatusCodeValue() == 200
    }

    def "Ejecucion endpoint /sign-up"(){

        given: "La siguiente configuracion"
        Set<Telephone> telephones = new ArrayList<>();
        telephones.add("1234-5678")
        UserDTO user = new UserDTO(1,"diego","diego@maceira.com","Password123",telephones)

        userService.save(_) >> user

        when: "se ejecuta saveUser"
        def respuesta = controller.saveUser(user)

        then: "Se obtiene mensaje de status ok"
        assert respuesta.getStatusCodeValue() == 200
    }

}
