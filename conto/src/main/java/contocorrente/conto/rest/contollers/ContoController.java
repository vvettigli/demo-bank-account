package contocorrente.conto.rest.contollers;


import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contocorrente.conto.services.ContoService;
import contocorrente.conto.services.OperationService;
import contocorrente.conto.services.UserService;

import contocorrente.entities.Conto;
import contocorrente.entities.Operation;
import contocorrente.entities.User;

@RestController
public class ContoController {


    @Autowired
	UserService userService;
    @Autowired
    OperationService operationService;
    @Autowired
    ContoService contoService;
   
 

    @GetMapping("/hello")
    public String hello(){
        return "HELLO";
    }
    @PostMapping("/newuser")
    public User newUser(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()){
           throw new  RuntimeException(result.toString());
        }
        user = userService.addUser(user);

        return user; 
    }
    @PostMapping("/createconto")
    public Conto createConto(@RequestBody @Valid Conto conto, BindingResult result){
        if(result.hasErrors()){
           throw new  RuntimeException(result.toString());
        }
        conto = contoService.addConto(conto);
        
        return conto; 
    }
    @GetMapping("/user/{id}")
    public User user(@PathVariable String id ){

        User user =  userService.getUser(id);
        return user; 
    }
    @PostMapping("/deposito")
    public Conto deposito(@RequestBody @Valid Operation operation, BindingResult result){
        if(result.hasErrors()){
            throw new  RuntimeException(result.toString());
         }
        operationService.addOperation(operation);
        Conto conto = contoService.getConto(operation.getUserID());
        Double saldo = conto.getSaldo();
        Double valore = operation.getValore(); 
        conto.setSaldo(saldo+valore);
        contoService.addConto(conto);
        return conto;
        
        }
    @GetMapping("/conto/{id}")
    public Conto conto(@PathVariable String id){

        Conto conto = contoService.getConto(id);
        return conto;
    }

    }


 