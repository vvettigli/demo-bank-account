package contocorrente.conto.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.dao.UserRepository;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.dto.UserFisicoDto;
import contocorrente.conto.dto.UserGiuridicoDto;
import contocorrente.conto.entities.Users;
import contocorrente.conto.services.UserService;

// @MockBeans({ @MockBean(UserService.class) })
@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityToDtoMapper converter;


    @Test
    void giveUserDtoShouldSaveAndReturnSameUserDto() {
        // given
        UserDto userDto = UserDto.builder()
                                    .id(1)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .build();
        // when
        UserDto userDtoVer = userService.addUser(userDto);
        // then
        assertEquals(userDto, userDtoVer);

    }

    @Test
    void giveUserFisicoDtoShouldSaveAndReturnSameUserFisicoDto() {
        // given
        UserFisicoDto userFisicoDto = UserFisicoDto.builder()
                                    .id(2)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .codiceFiscale("AWEG2987WQ")
                                    .build();
        // when
        UserFisicoDto userFisicoDtoVer = userService.addUser(userFisicoDto);
        // then
        assertEquals(userFisicoDto, userFisicoDtoVer);

    }

    @Test
    void giveUserGiuridicoDtoShouldSaveAndReturnSameUserGiuridicoDto() {
        // given
        UserGiuridicoDto userGiuridicoDto = UserGiuridicoDto.builder()
                                    .id(3)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .partitaIva("PV123598")
                                    .build();
        // when
        UserGiuridicoDto userGiuridicoDtoVer = userService.addUser(userGiuridicoDto);
        // then
        assertEquals(userGiuridicoDto, userGiuridicoDtoVer);

    }

    @Test
    void giveIdShouldReturnUserDto(){
        //give
        Integer id = 4;
        UserDto userDto = UserDto.builder()
                                    .id(id)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .build();
        userService.addUser(userDto);
        //when
        UserDto userDtoVer = userService.getUser(id);
        //then
        assertEquals(userDto, userDtoVer);

    }

    @Test
    void giveIdShouldReturnUserFisicoDto(){
        //give
        Integer id = 5;
        UserFisicoDto userFisicoDto = UserFisicoDto.builder()
                                    .id(id)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .build();
        userService.addUser(userFisicoDto);
        //when
        UserFisicoDto userFisicoDtoVer = UserFisicoDto.class.cast(userService.getUser(id));
        //thenGiuridico
        assertEquals(userFisicoDto, userFisicoDtoVer);

    }

    @Test
    void giveIdShouldReturnUserGiuridicoDto(){
        //give
        Integer id = 6;
        UserGiuridicoDto userGiuridicoDto = UserGiuridicoDto.builder()
                                    .id(id)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .build();
        userService.addUser(userGiuridicoDto);
        //when
        UserGiuridicoDto userGiuridicoDtoVer = UserGiuridicoDto.class.cast(userService.getUser(id));
        //then
        assertEquals(userGiuridicoDto, userGiuridicoDtoVer);

    }
    
    @Test
    void giveUserDtoShouldUpdateAndReturnDifferentUserDto() {
        // given
        UserDto userDto = UserDto.builder()
                                    .id(7)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .build();
        userService.addUser(userDto);

         UserDto userDtoUpdate = UserDto.builder()
                                    .id(7)
                                    .userName("usernameUpdate")
                                    .password("passwordUpdate")
                                    .build();
        // when
        UserDto userDtoVer = userService.updateUser(userDtoUpdate);
        // then
        assertNotEquals(userDto, userDtoVer);

    }

    @Test
    void giveUserFisicoDtoShouldUpdateAndReturnDifferentUserFisicoDto() {
        // given
        UserFisicoDto userFisicoDto = UserFisicoDto.builder()
                                    .id(8)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .codiceFiscale("ART231ASX")
                                    .build();
        userService.addUser(userFisicoDto);

        UserFisicoDto userFisicoDtoUpdate = UserFisicoDto.builder()
                                    .id(8)
                                    .userName("usernameUpdate")
                                    .password("passwordUpdate")                  
                                    .codiceFiscale("ART231ASX")
                                    .build();
        // when
        UserFisicoDto userFisicoDtoVer = userService.updateUser(userFisicoDtoUpdate);
        // then
        assertNotEquals(userFisicoDto, userFisicoDtoVer);

    }

    @Test
    void giveUserGiuridicoDtoShouldUpdateAndReturnDifferentUserGiuridicoDto() {
        // given
        UserGiuridicoDto userGiuridicoDto = UserGiuridicoDto.builder()
                                    .id(9)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .partitaIva("PV21235")
                                    .build();
        userService.addUser(userGiuridicoDto);

         UserGiuridicoDto userGiuridicoDtoUpdate = UserGiuridicoDto.builder()
                                    .id(9)
                                    .userName("usernameUpdate")
                                    .password("passwordUpdate")
                                    .partitaIva("PV21235")
                                    .build();
        // whenFisico
        UserGiuridicoDto userGiuridicoDtoVer = userService.updateUser(userGiuridicoDtoUpdate);
        // then
        assertNotEquals(userGiuridicoDto, userGiuridicoDtoVer);

    }
    
    @Test
    void returnAListOfUserDto(){
        //give
        List<Users> lista = userRepository.findAll().stream().collect(Collectors.toList());
        List <UserDto> listaConvertita = converter.allUsersEntitiesToUsersDto(lista);
        UserDto array[] = new UserDto[lista.size()];
        for(int i = 0; i<listaConvertita.size()-1;i++){

            array[i] = listaConvertita.get(i);
        }
        //when
        List<UserDto> listaMethod = userService.getAllUser();
        UserDto arrayVer[] = new UserDto[listaMethod.size()];
        for(int i = 0; i<listaMethod.size()-1;i++){

            arrayVer[i] = listaMethod.get(i);
        }
        //then
        assertArrayEquals(array, arrayVer);
        
    }
    @Test
    void giveUserDtoShouldDeleteUserDto(){
        //give
        UserDto userDto = UserDto.builder()
                                    .id(10)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .build();
        userService.addUser(userDto);
        //when
        userService.deleteUser(userDto.getId());
        //then
        assertThrows(NotFoundException.class,() -> userService.getUser(userDto.getId()));
    


    }
}
