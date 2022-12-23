package contocorrente.conto.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.HandleException.AlreadyExistsException;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.dao.UserFisicoRepository;
import contocorrente.conto.dao.UserGiuridicoRepository;
import contocorrente.conto.dao.UserRepository;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.dto.UserFisicoDto;
import contocorrente.conto.dto.UserGiuridicoDto;
import contocorrente.conto.entities.Users;
import lombok.RequiredArgsConstructor;
import contocorrente.conto.entities.UserFisico;
import contocorrente.conto.entities.UserGiuridico;

@Service
@RequiredArgsConstructor
public class UserServiceImpl <T extends UserDto>  implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserFisicoRepository userFisicoRepository;
    @Autowired
    UserGiuridicoRepository userGiuridicoRepository;
    @Autowired
    EntityToDtoMapper converter;

    @Override
    public UserDto addUser(UserDto userDto) {
        logger.debug("addUser start");
        List<UserDto> listaUser = getAllUser();
        if(listaUser != null){
        for (int i = 0; i < listaUser.size(); i++) {
            UserDto convalidaUserDto = listaUser.get(i);
                if (convalidaUserDto.getId()==userDto.getId()) {
                    logger.debug("addUser end {}" , userDto.getId());
                    throw new AlreadyExistsException("user already exists");
            }

        }
    }
        Users user = converter.userDtoToUser(userDto);
        userRepository.save(user);

            logger.debug("addUser end");

        return converter.userToUserDto(user);

     }

     @Override
     public UserFisicoDto addUser(UserFisicoDto userFisicoDto) {
        logger.debug("addUserFisico start");
        List<UserDto> listaUser = getAllUser();
        if(listaUser != null){
        for (int i = 0; i < listaUser.size(); i++) {
            UserDto convalidaUserDto = listaUser.get(i);
                if (convalidaUserDto.getId()==userFisicoDto.getId()) {
                    logger.debug("addUserFisico end whit error 'id' = {}" , userFisicoDto.getId());
                    throw new AlreadyExistsException("user already exists");
            }

        }
    }

        UserFisico userFisico = converter.userFisicoDtoToUserFisico(userFisicoDto);
        userFisicoRepository.save(userFisico);

            logger.debug("addUserFisico end");

        return converter.userFisicoToUserFisicoDto(userFisico);
     }
 
 
 
 
     @Override
     public UserGiuridicoDto addUser(UserGiuridicoDto userGiuridicoDto) {
        logger.debug("addUserGiuridico start");
        List<UserDto> listaUser = getAllUser();

        if(listaUser != null){

        for (int i = 0; i < listaUser.size(); i++) {
            UserDto convalidaUserDto = listaUser.get(i);
                if (convalidaUserDto.getId()==userGiuridicoDto.getId()) {
                    logger.debug("addUserGiuridico end whit error id = {}" , userGiuridicoDto.getId());
                    throw new AlreadyExistsException("user already exists");
            }

        }

    }
        UserGiuridico userGiuridico = converter.userGiuridicoDtoToUserGiuridico(userGiuridicoDto);
        userGiuridicoRepository.save(userGiuridico);

            logger.debug("addUserGiuridico end");

        return converter.userGiuridicoToUserGiuridicoDto(userGiuridico);
     }


    
    @Override
    public List<UserDto> getAllUser() {
        logger.debug("getAllUser start");


        List<Users> listaUser = userRepository.findAll().stream().collect(Collectors.toList());
        

        logger.debug("getAllUser end");
         return converter.allUsersEntitiesToUsersDto(listaUser);
    }

    @Override
    public T getUser(Integer id) throws NoSuchElementException {
        logger.debug("getUser start");
        try {

            Users user = userRepository.findById(id).get();
            if(UserFisico.class.isAssignableFrom(user.getClass())){
                return (T) converter.userFisicoToUserFisicoDto(UserFisico.class.cast(user));
            }else if(UserGiuridico.class.isAssignableFrom(user.getClass())){
                return (T) converter.userGiuridicoToUserGiuridicoDto(UserGiuridico.class.cast(user));
            }else {
                return (T) converter.userToUserDto(user);
            }
            
        } catch (NoSuchElementException e) {
            throw NotFoundException.of("non esiste user con id " + id);
        } finally {
            logger.debug("getUser end");

        }

    }

    

    @Override
    public UserDto updateUser(UserDto userDtoUpdate){
        logger.debug("updateUser start");
        Users user = userRepository.findById(userDtoUpdate.getId())
                    .orElseThrow(() ->  NotFoundException.of("il conto con id " + userDtoUpdate.getId() + " non esiste"));

        user = converter.userDtoToUser(userDtoUpdate);
        userRepository.save(user);
        return converter.userToUserDto(user);
        
    }
    @Override
    public UserFisicoDto updateUser(UserFisicoDto userFisicoDtoUpdate){
        logger.debug("updateUserFisico start");
        Users user = userRepository.findById(userFisicoDtoUpdate.getId())
                    .orElseThrow(() ->  NotFoundException.of("il conto con id " + userFisicoDtoUpdate.getId() + " non esiste"));
        UserFisico userFisico = UserFisico.class.cast(user);
        userFisico = converter.userFisicoDtoToUserFisico(userFisicoDtoUpdate);
        userFisicoRepository.save(userFisico);
        return converter.userFisicoToUserFisicoDto(userFisico);
        
    }
    
    @Override
    public UserGiuridicoDto updateUser(UserGiuridicoDto userGiuridicoDtoUpdate){
        logger.debug("updateUser start");
        Users user = userRepository.findById(userGiuridicoDtoUpdate.getId())
                    .orElseThrow(() ->  NotFoundException.of("il conto con id " + userGiuridicoDtoUpdate.getId() + " non esiste"));
        UserGiuridico userGiuridico = UserGiuridico.class.cast(user);
        userGiuridico = converter.userGiuridicoDtoToUserGiuridico(userGiuridicoDtoUpdate);
        userGiuridicoRepository.save(userGiuridico);
        return converter.userGiuridicoToUserGiuridicoDto(userGiuridico);
        
    }

    @Override
    public void deleteUser(Integer id) {
        logger.debug("DeleteUser start");
        T userDaEliminare = getUser(id);
        if(UserFisicoDto.class.isAssignableFrom(userDaEliminare.getClass())){
            UserFisico userFisico = converter.userFisicoDtoToUserFisico(UserFisicoDto.class.cast(userDaEliminare));
            userRepository.delete(userFisico);
        }else if(UserGiuridicoDto.class.isAssignableFrom(userDaEliminare.getClass())){
            UserGiuridico userGiuridico = converter.userGiuridicoDtoToUserGiuridico(UserGiuridicoDto.class.cast(userDaEliminare));
            userRepository.delete(userGiuridico);
        }else {
            Users user = converter.userDtoToUser(UserDto.class.cast(userDaEliminare));
            userRepository.delete(user);
        }
        logger.debug("DeleteUser end");
        


        
    }




}

