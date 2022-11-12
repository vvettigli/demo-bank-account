package contocorrente.conto.rest.contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contocorrente.dao.UserRepository;
import contocorrente.entities.Operation;
import contocorrente.entities.User;

@RestController
public class ContoController {


    @Autowired
	UserRepository userRepository;
    
    User user;
    Operation operation;

    @GetMapping("/hello")
    public String hello(){
        return "HELLO";
    }
    @GetMapping("/newuser")
    public String newUser(@Valid User user, BindingResult result){
        if(result.hasErrors()){
           return result.toString();
        }
        
        return "user add " + user.getId()+ " " + user.getUserName() + " saldo: " ;
    }
    @GetMapping("/user")
    public String user(String id){
        if(id == user.getId()){
            return user.toString();
        }
        return "l'utente non esiste"; 
    }
    @GetMapping("/deposito")
    public String deposito(Operation operation){
        if(user.getId()== operation.getUserID()){
        
       // user.setSaldo(user.getSaldo()+this.operation.getValore());
        return "deposito effetuato di: " + operation.getValore() ;
        }else{
            return "non esiste un account con id = " + operation.getId();
        }
        
    }

}
 