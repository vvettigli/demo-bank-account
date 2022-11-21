package contocorrente.conto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.conto.Converter.UserConverter;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.dao.UserRepository;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.User;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    public User addUser(UserDto userDto){

       User user = userConverter.dtoToEntity(userDto);

        return userRepository.save(user);
    }

    public List<UserDto> getAllUser(){

        List<User> listaConto = userRepository.findAll().stream().collect(Collectors.toList());

        return userConverter.allEntityToDto(listaConto);
    }

    public UserDto getUser(Integer id){ 

        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Utente con id " + id + " non esiste ") );
        
            return userConverter.entityToDto(user);
           
    }

    public User updateUser(int id, User conto){
        return userRepository.save(conto);
    }

    public void deleteUserById(Integer id){
        userRepository.deleteById(id);
    }
    
}
