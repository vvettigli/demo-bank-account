package contocorrente.conto.rest.contollers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import contocorrente.dao.UserRepository;
import contocorrente.entities.Operation;
import contocorrente.entities.User;

@RestController
public class ContoController {


    @Autowired
	UserRepository userRepository;
    
   
 

    @GetMapping("/hello")
    public String hello(){
        return "HELLO";
    }
    @PostMapping("/newuser")
    public User newUser(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()){
           throw new  RuntimeException(result.toString());
        }
        user = userRepository.save(user);

        return user; 
    }
    @GetMapping("/user/{id}")
    public User user(@PathVariable String id ){

        User user =  userRepository.getReferenceById(id);
        return user; 
    }
    @GetMapping("/deposito")
    public String deposito(Operation operation){

        return null;
        /* 
        if(user.getId()== operation.getUserID()){
        
       // user.setSaldo(user.getSaldo()+this.operation.getValore());
        return "deposito effetuato di: " + operation.getValore() ;
        }else{
            return "non esiste un account con id = " + operation.getId();
        }
        */
    }

}
 