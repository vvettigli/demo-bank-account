package contocorrente.conto.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.dao.ContoRepository;
import contocorrente.conto.dto.ContoBancaDto;
import contocorrente.conto.dto.ContoBorsellinoDto;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.ContoPaypalDto;
import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.Conto;
import contocorrente.conto.entities.ContoBorsellino;
import contocorrente.conto.services.ContoService;
import contocorrente.conto.services.UserService;

@SpringBootTest
public class ContoServiceTest {
    
    @Autowired
    ContoService contoService;
    @Autowired
    UserService userService; 
    @Autowired
    EntityToDtoMapper converter;
    @Autowired
    ContoRepository contoRepository;


   


    @Test
    void createNewContoShouldAddAndReturnConto(){
        //give

        UserDto userDto = UserDto.builder()
                                .id(1)
                                .userName("usernameTest")
                                .password("passwordTest")
                                .build();

        userService.addUser(userDto);

        ContoDto contoDto = ContoDto.builder()
                                    .id(1)
                                    .saldo(10.10)
                                    .userDto(userDto)
                                    .build();
        //when 
        ContoDto contoDtoVer = contoService.addConto(contoDto);
        //then
        assertEquals(contoDto, contoDtoVer);

    }

    @Test
    void createNewContoBancaShouldAddAndReturnContoBanca(){
        //give

        UserDto userDto = UserDto.builder()
                                .id(2)
                                .userName("usernameTest")
                                .password("passwordTest")
                                .build();

        userService.addUser(userDto);

        ContoBancaDto contoBancaDto = ContoBancaDto.builder()
                                    .id(2)
                                    .saldo(10.10)
                                    .iban("123DSW")
                                    .userDto(userDto)
                                    .build();
        //when 
        ContoBancaDto contoBancaDtoVer = contoService.addConto(contoBancaDto);
        //then
        assertEquals(contoBancaDto, contoBancaDtoVer);

    }

    @Test
    void createNewContoBorsellinoShouldAddAndReturnContoBorsellino(){
        //give

        UserDto userDto = UserDto.builder()
                                .id(3)
                                .userName("usernameTest")
                                .password("passwordTest")
                                .build();

        userService.addUser(userDto);

        ContoBorsellinoDto contoBorsellinoDto = ContoBorsellinoDto.builder()
                                    .id(3)
                                    .saldo(10.10)
                                    .meccanismoDiApertura(true)
                                    .userDto(userDto)
                                    .build();
        //when 
        ContoBorsellinoDto contoBorsellinoDtoVer = contoService.addConto(contoBorsellinoDto);
        //then
        assertEquals(contoBorsellinoDto, contoBorsellinoDtoVer);

    }

    @Test
    void createNewContoPaypalShouldAddAndReturnContoPaypal(){
        //give

        UserDto userDto = UserDto.builder()
                                .id(4)
                                .userName("usernameTest")
                                .password("passwordTest")
                                .build();

        userService.addUser(userDto);

        ContoPaypalDto contoPaypalDto = ContoPaypalDto.builder()
                                    .id(4)
                                    .saldo(10.10)
                                    .cartaDiCredito("23589198700")
                                    .userDto(userDto)
                                    .build();
        //when 
        ContoPaypalDto contoPaypalDtoVer = contoService.addConto(contoPaypalDto);
        //then
        assertEquals(contoPaypalDto, contoPaypalDtoVer);

    }

    @Test
    void returnAListOfContoDto(){
        //give
        List<Conto> lista = contoRepository.findAll().stream().collect(Collectors.toList());
        List <ContoDto> listaConvertita = converter.allContoEntitiesToContoDto(lista);
        ContoDto array[] = new ContoDto[lista.size()];
        for(int i = 0; i<listaConvertita.size()-1;i++){

            array[i] = listaConvertita.get(i);
        }
        //when
        List<ContoDto> listaMethod = contoService.getAllConti();
        ContoDto arrayVer[] = new ContoDto[listaMethod.size()];
        for(int i = 0; i<listaMethod.size()-1;i++){

            arrayVer[i] = listaMethod.get(i);
        }
        //then
        assertArrayEquals(array, arrayVer);
        
    }

    @Test
    void giveIdShouldReturnContoDto(){
        //give

        Integer id = 5;
        UserDto userDto = UserDto.builder()
                                .id(id)
                                .userName("usernameTest")
                                .password("passwordTest")
                                .build();

        userService.addUser(userDto);

        ContoDto contoDto = ContoDto.builder()
                                    .id(id)
                                    .saldo(300.00)
                                    .userDto(userDto)
                                    .build();
        contoService.addConto(contoDto);
        //when
        ContoDto contoDtoVer = ContoDto.class.cast(contoService.getConto(id));
        contoDtoVer.setOperationDto(null);
        //then
        assertEquals(contoDto, contoDtoVer);

}

    @Test
    void givenContoShouldThrowNotFoundException(){

        //give
        Integer id = 6;
        UserDto userDto = UserDto.builder()
                                .id(id)
                                .userName("usernameTest")
                                .password("passwordTest")
                                .build();

        userService.addUser(userDto);

        ContoDto contoDto = ContoDto.builder()
                                    .id(id)
                                    .saldo(300.00)
                                    .userDto(userDto)
                                    .build();
        contoService.addConto(contoDto);
        //when
        contoService.deleteConto(id);
        //then
        assertThrows(NotFoundException.class,() -> contoService.getConto(id));

    }
}
