package contocorrente.conto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import contocorrente.dao.UserRepository;
import contocorrente.entities.User;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User conto){
        return userRepository.save(conto);
    }

    public List<User> getAllUser(){

        List<User> conti= new ArrayList<User>();
        userRepository.findAll().forEach(conti::add);
        return conti;

    }
    public User getUser(String id){
        return userRepository.getById(id);
    }

    public User updateUser(int id, User conto){
        return userRepository.save(conto);
    }
    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
    
}
