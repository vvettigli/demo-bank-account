package contocorrente.conto.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.dao.ContoRepository;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.dto.UserDto;
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


    UserDto userDto;
    OperationDto operationDto;

    @BeforeEach
    void setup(){
        userDto = UserDto.builder().id(100).userName("usernameTest").password("passwordTest").build();
        userService.addUser(userDto);
        
        operationDto = new OperationDto();
    }

   
    @Test
    void createNewContoShouldAddAndReturnConto(){
        //give

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
}
