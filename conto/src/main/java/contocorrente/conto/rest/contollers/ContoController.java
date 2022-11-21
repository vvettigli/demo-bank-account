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

import contocorrente.conto.Converter.UserConverter;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.Conto;
import contocorrente.conto.entities.Operation;
import contocorrente.conto.entities.User;
import contocorrente.conto.services.ContoService;
import contocorrente.conto.services.OperationService;
import contocorrente.conto.services.UserService;

@RestController
public class ContoController {


    @Autowired
	UserService userService;
    @Autowired
    OperationService operationService;
    @Autowired
    ContoService contoService;
    @Autowired
    UserConverter userConverter;
   
 

    @GetMapping("/hello")
    public String hello(){
        return "HELLO";
    }
    @PostMapping("/newuser")
    public UserDto newUser(@RequestBody @Valid UserDto userDto, BindingResult result){
        if(result.hasErrors()){
           throw new  RuntimeException(result.toString());
        }
        userService.addUser(userDto);
        return userDto;
        
    }
    @PostMapping("/createconto")
    public ContoDto createConto(@RequestBody @Valid Conto conto, BindingResult result){
        if(result.hasErrors()){
           throw new  RuntimeException(result.toString());
        }
        
        return contoService.addConto(conto); 
    }
    @GetMapping("/user/{id}")
    public UserDto user(@PathVariable Integer id ){

        return userService.getUser(id);
         
    }
    // @PostMapping("/deposito")
    // public Conto deposito(@RequestBody @Valid Operation operation, BindingResult result){
    //     if(result.hasErrors()){
    //         throw new  RuntimeException(result.toString());
    //      }
    //     operationService.addOperation(operation);
    //     Conto conto = contoService.getConto(operationService.getUserID());
    //     Double saldo = conto.getSaldo();
    //     Double valore = operation.getValore(); 
    //     conto.setSaldo(saldo+valore);
    //     contoService.addConto(conto);
    //     return conto;
        
    // }


    @GetMapping("/conto/{id}")
    public ContoDto conto(@PathVariable Integer id){

        return contoService.getConto(id);
    }

    // @GetMapping("/allconti")
    // public List<ContoDto> Allconti(){
    //     return contoService.getAllConti();
    // }

    // @PostMapping("/updateconto")
    // public ContoDto updateConto(Integer id, Conto conto){
    //     return contoService.updateConto(id, conto);
    // }
    }


 