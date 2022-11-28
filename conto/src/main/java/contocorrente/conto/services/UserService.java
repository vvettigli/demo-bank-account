package contocorrente.conto.services;

import java.util.List;
import java.util.NoSuchElementException;

import contocorrente.conto.dto.UserDto;

public interface UserService {
    
    public UserDto addUser(UserDto userDto);
    
    public List<UserDto> getAllUser();

    public UserDto getUser(Integer id) throws NoSuchElementException;

    public UserDto updateUser(UserDto userDtoUpdate);

    public void deleteUser(Integer id);
}
