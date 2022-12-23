package contocorrente.conto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.dao.UserRepository;
import contocorrente.conto.dto.UserDto;
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

    // EntityToDtoMapper converter;

    @Test
    void nomeDaCambiare() {
        // given

        UserDto userDto = new UserDto(1, "usernameTest", "passwordTest");

        // when
        // Mockito.when(userService.addUser((UserDto)any())).thenReturn(userDto);

        UserDto userDtoVer = userService.addUser(userDto);
        // then
        assertEquals(userDto, userDtoVer);

    }

}
