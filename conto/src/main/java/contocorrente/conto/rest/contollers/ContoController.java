package conto_corrente.conto.A.restContoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conto_corrente.Entity.operation;
import conto_corrente.Entity.user;

@RestController
public class restController {

    user user;
    operation operation;

    @RequestMapping("/hello")
    public String hello(){
        return "HELLO";
    }
    @RequestMapping("/newuser")
    public String newUser(@Valid user user, BindingResult result){
        if(result.hasErrors()){
           return result.toString();
        }
        
        return "user add " + user.getId()+ " " + user.getUsername() + " saldo: " + user.getSaldo();
    }
    @RequestMapping("/user")
    public String user(String id){
        if(id == user.getId()){
            return user.toString();
        }
        return "l'utente non esiste"; 
    }
    @RequestMapping("/deposito")
    public String deposito(operation operation){
        if(user.getId()== operation.getIdUser1()){
        
        user.setSaldo(user.getSaldo()+this.operation.getValore());
        return "deposito effetuato di: " + operation.getValore() + " ora il tuo saldo è di: " + user.getSaldo();
        }else{
            return "non esiste un account con id = " + operation.getId();
        }
        
    }

}
 