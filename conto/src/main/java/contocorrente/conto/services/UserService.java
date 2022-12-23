package contocorrente.conto.services;

import java.util.List;
import java.util.NoSuchElementException;

import contocorrente.conto.dto.UserDto;
import contocorrente.conto.dto.UserFisicoDto;
import contocorrente.conto.dto.UserGiuridicoDto;

public interface UserService <T extends UserDto> {
    
    public UserDto addUser(UserDto userDto);

    public UserFisicoDto addUser(UserFisicoDto userFisicoDto);

    public UserGiuridicoDto addUser(UserGiuridicoDto userGiuridicoDto);
    
    public List<UserDto> getAllUser();

    public T getUser(Integer id) throws NoSuchElementException;

    public UserDto updateUser(UserDto userDtoUpdate);

    public UserFisicoDto updateUser(UserFisicoDto userFisicoDtoUpdate);

    public UserGiuridicoDto updateUser(UserGiuridicoDto userGiuridicoDtoUpdate);

    public  void deleteUser(Integer id);

    

}
 