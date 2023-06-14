package cl.bci.mapper

import cl.bci.dto.TelephoneDTO
import cl.bci.dto.UserDTO
import cl.bci.model.Telephone
import cl.bci.model.User
import spock.lang.Specification

class UserMapperSpec extends Specification{

    def mapper

    def setup(){
        mapper = new UserMapper()
    }

    def "Convertir user model to user dto"(){

        given: "La siguiente configuracion"
        Set<Telephone> telephones = new ArrayList<>();
        telephones.add(new Telephone(1,1234,1,"ARG"))
        User userModel = new User(1,"diego","diego@maceira.com","Password123",telephones)

        when: "se ejecuta convertUserToUserDTO"
        def respuesta = mapper.convertUserToUserDTO(userModel)

        then: "Se obtiene el objeto mapeado"
        assert respuesta != null
    }

    def "Convertir user dto to user model"(){

        given: "La siguiente configuracion"
        Set<TelephoneDTO> telephones = new ArrayList<>();
        telephones.add(new TelephoneDTO(1,1234,1,"ARG"))
        UserDTO userDto = new UserDTO(1,"diego","diego@maceira.com","Password123",telephones)

        when: "se ejecuta convertUserDTOToUser"
        def respuesta = mapper.convertUserDTOToUser(userDto)

        then: "Se obtiene el objeto mapeado"
        assert respuesta != null
    }

}
