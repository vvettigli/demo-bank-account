package contocorrente.conto.Converter;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.User;

@Component
public class UserConverter {


    public UserDto entityToDto(User user){

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUserName());
        dto.setPassword(user.getPassword());
        return dto;

    }

    public User dtoToEntity(UserDto dto){

        User user = new User();
        user.setId(dto.getId());
        user.setUserName(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }

    
    public List<UserDto> allEntityToDto(List<User> user){
        return user.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public List<User> allDtoToEntity(List<UserDto> userDto){
        return userDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}