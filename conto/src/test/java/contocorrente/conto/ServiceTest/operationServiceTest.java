package contocorrente.conto.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.Operation;
import contocorrente.conto.services.ContoService;
import contocorrente.conto.services.OperationService;
import contocorrente.conto.services.UserService;

@SpringBootTest
public class operationServiceTest {
    
    @Autowired
    OperationService operationService;
    @Autowired
    ContoService contoService;
    @Autowired
    UserService userService;
    @Autowired
    EntityToDtoMapper converter;


    @Test 
    void givenOperationShouldAddOperationInAnConto(){
        
        //give 
        int id = 1;
        UserDto userDto = UserDto.builder().id(id).userName("usernameTest").password("passwordTest").build();
        userService.addUser(userDto);
        ContoDto contoDto = ContoDto.builder().id(id).userDto(userDto).saldo(1.00).build();
        contoService.addConto(contoDto);
        OperationDto operationDto = OperationDto.builder().id(id).ammontare(100.00).contoDto(contoDto).build();
        //when
        OperationDto operationDtoVer = operationService.addOperation(operationDto);
        //then
        operationDto.setContoDto(operationDtoVer.getContoDto());
        assertEquals(operationDto, operationDtoVer);
        
    }
    @Test
    void givenOperationShouldReturnContoWhitOperationChild(){
            //give
            int id = 2;
            UserDto userDto = UserDto.builder()
                                    .id(id)
                                    .userName("usernameTest")
                                    .password("passwordTest")
                                    .build();
    
            userService.addUser(userDto);
    
            ContoDto contoDto = ContoDto.builder()
                                        .id(id)
                                        .saldo(10.10)
                                        .userDto(userDto)
                                        .build();
            contoService.addConto(contoDto);
            OperationDto operationDto = OperationDto.builder().id(id).ammontare(100.00).contoDto(contoDto).build();
            OperationDto operationDto2 = OperationDto.builder().id(3).ammontare(100.00).contoDto(contoDto).build();

            operationService.addOperation(operationDto);
            operationService.addOperation(operationDto2);

            //when
           ContoDto contoDtoVer =  contoService.getConto(contoDto.getId());
            //then
            assertFalse(contoDtoVer.getOperationDto().isEmpty());   

    
        }


    @Test
    void givenIdShouldReturnOperationDto(){

          //give 
          int id = 4;
          UserDto userDto = UserDto.builder().id(id).userName("usernameTest").password("passwordTest").build();
          userService.addUser(userDto);
          ContoDto contoDto = ContoDto.builder().id(id).userDto(userDto).saldo(1.00).build();
          contoService.addConto(contoDto);
          OperationDto operationDto = OperationDto.builder().id(id).ammontare(100.00).contoDto(contoDto).build();
          operationService.addOperation(operationDto);
          //when
          OperationDto operationDtoVer = operationService.getOperation(id);
          operationDto.setContoDto(operationDtoVer.getContoDto());
          //then
          assertEquals(operationDto, operationDtoVer);



    }

    @Test
    void givenSomeOperationDtoShouldReturnListOfOperationDto(){
        //give
        int id = 5;
        UserDto userDto = UserDto.builder()
                                .id(id)
                                .userName("usernameTest")
                                .password("passwordTest")
                                .build();

        userService.addUser(userDto);

        ContoDto contoDto = ContoDto.builder()
                                    .id(id)
                                    .saldo(10.10)
                                    .userDto(userDto)
                                    .build();
        contoService.addConto(contoDto);
        OperationDto operationDto = OperationDto.builder().id(id).ammontare(100.00).contoDto(contoDto).build();
        OperationDto operationDto2 = OperationDto.builder().id(6).ammontare(100.00).contoDto(contoDto).build();
        OperationDto operationDto3 = OperationDto.builder().id(7).ammontare(100.00).contoDto(contoDto).build();
        operationService.addOperation(operationDto);
        operationService.addOperation(operationDto2);
        operationService.addOperation(operationDto3);
        OperationDto[] operationArray = {operationDto,operationDto2,operationDto3};

        //when
        List<OperationDto> operationListVer = operationService.getAllOperations();
        OperationDto[] operationArrayVer = new OperationDto[operationListVer.size()];
        for(int i = 0; i<=operationListVer.size()-1;i++){
            operationArrayVer[i] = operationListVer.get(i); 
        }
        //then
        Arrays.deepEquals(operationArray, operationArrayVer);

    }
    @Test
    void givenOperationDtoShouldThrowsNotFoundException(){
        //give
        int id = 8;
          UserDto userDto = UserDto.builder().id(id).userName("usernameTest").password("passwordTest").build();
          userService.addUser(userDto);
          ContoDto contoDto = ContoDto.builder().id(id).userDto(userDto).saldo(1.00).build();
          contoService.addConto(contoDto);
          OperationDto operationDto = OperationDto.builder().id(id).ammontare(100.00).contoDto(contoDto).build();
          operationService.addOperation(operationDto);
        //when
        operationService.deleteOperation(id);
        //then
        assertThrows(NotFoundException.class,() -> operationService.getOperation(id));
    }
}
