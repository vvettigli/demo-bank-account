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
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import contocorrente.dao.ContoRepository;
import contocorrente.dao.OperationRepository;
import contocorrente.dao.UserRepository;
import contocorrente.entities.Conto;
import contocorrente.entities.Operation;
import contocorrente.entities.User;

@RestController
public class ContoController {


    @Autowired
	UserRepository userRepository;
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    ContoRepository contoRepository;
   
 

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
    @PostMapping("/createconto")
    public Conto createConto(@RequestBody @Valid Conto conto, BindingResult result){
        if(result.hasErrors()){
           throw new  RuntimeException(result.toString());
        }
        conto = contoRepository.save(conto);
        
        return conto; 
    }
    @GetMapping("/user/{id}")
    public User user(@PathVariable String id ){

        User user =  userRepository.getReferenceById(id);
        return user; 
    }
    @PostMapping("/deposito")
    public String deposito(@RequestBody @Valid Operation operation, BindingResult result){
        if(result.hasErrors()){
            throw new  RuntimeException(result.toString());
         }
        operationRepository.save(operation);
        Conto conto = contoRepository.findByUserID(operation.getUserID());
        Double x = conto.getSaldo();
        Double y = operation.getValore(); 
        conto.setSaldo(x+y);
        contoRepository.save(conto);
        return "deposito effetuato di: " + operation.getValore();
        
        }
    @GetMapping("/conto/{id}")
    public Conto conto(@PathVariable String id){

        Conto conto = contoRepository.getReferenceById(id);
        return conto;
    }

    }


 