package contocorrente.conto.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import contocorrente.conto.Converter.UserConverter;
import contocorrente.conto.HandleException.AlreadyExistsException;
import contocorrente.conto.HandleException.ApiError;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.HandleException.NullException;
import contocorrente.conto.dao.UserRepository;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.User;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    public UserDto addUser(UserDto userDto) {
        logger.debug("addUser start");
        List<UserDto> listaUser = getAllUser();

        for (int i = 0; i < listaUser.size(); i++) {
            UserDto convalidaUserDto = listaUser.get(i);
            if (!(convalidaUserDto.equals(userDto))) {
                logger.debug("addUser end");
                throw new AlreadyExistsException("user already exists");
            }

        }
        User user = userConverter.dtoToEntity(userDto);
        userRepository.save(user);
        logger.debug("addUser end");
        return userConverter.entityToDto(user);
    }

    public List<UserDto> getAllUser() {
        logger.debug("getAllUser start");
        List<User> listaUser = userRepository.findAll().stream().collect(Collectors.toList());
        if (listaUser.isEmpty()) {
            logger.debug("getAllUser end");
            throw new NullException("non esisteno users");
        }
        logger.debug("getAllUser end");
        return userConverter.allEntityToDto(listaUser);
    }

    public UserDto getUser(Integer id) throws NoSuchElementException {
        logger.debug("getUser start");
        User user = new User();
        try {

            user = userRepository.findById(id).get();

            return userConverter.entityToDto(user);

        } catch (NoSuchElementException e) {
            throw new NotFoundException("non esiste user con id " + id);
        } finally {
            logger.debug("getUser end");

        }

    }
    //NON SO DOVE METTERE logger.debug("updateUser end");

    public UserDto updateUser(UserDto userDtoUpdate){
        logger.debug("updateUser start");
        User user = userRepository.findById(userDtoUpdate.getId())
        .orElseThrow(() -> new NotFoundException("il conto con id " + userDtoUpdate.getId() + " non esiste"));
        user = userConverter.dtoToEntity(userDtoUpdate);
        userRepository.save(user);
        return userConverter.entityToDto(user);
        
    }

    public void deleteUser(Integer id) {
        logger.debug("DeleteUser start");
        User userDaEliminare = userConverter.dtoToEntity(getUser(id));
        userRepository.delete(userDaEliminare);
        logger.debug("DeleteUser end");

    }

}
