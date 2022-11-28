package contocorrente.conto.rest.contollers;



import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import contocorrente.conto.Converter.ContoConverter;
import contocorrente.conto.Converter.UserConverter;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.Conto;
import contocorrente.conto.entities.Operation;
import contocorrente.conto.services.ContoService;
import contocorrente.conto.services.OperationService;
import contocorrente.conto.services.UserService;

@RestController
public class ContoController {

    
    @Autowired
	UserService userService;
    @Autowired
    OperationService operationServiceInvernale;
    @Autowired
    ContoService contoService;
    @Autowired
    ContoConverter contoConverter;
    @Autowired
    UserConverter userConverter;

   Logger logger = LoggerFactory.getLogger(ContoController.class);
 

    @GetMapping("/hello")
    public String hello(){
        logger.info("ho chiamato {} method","hellopar");
        return "HELLO";
    }
    @PostMapping("/user")
    public UserDto newUser(@RequestBody @Valid UserDto userDto, BindingResult result){
        if(result.hasErrors()){
           throw new  RuntimeException(result.toString());
        }
        userService.addUser(userDto);
        return userDto;
        
    }
    
    @GetMapping("/user/{id}")
    public UserDto user(@PathVariable Integer id ){

        return userService.getUser(id);
         
    }

    @GetMapping("/allusers")
    public List<UserDto> getAllUser(){

       return userService.getAllUser();

    }
    
    @PutMapping("/user")
    public UserDto updateUser(@RequestBody UserDto userDto){

        return userService.updateUser(userDto);
    }

    @DeleteMapping("/user")
    public void deleteUser(Integer id){
        userService.deleteUser(id);
    }


    @PostMapping("/conto")
    public ContoDto createConto(@RequestBody @Valid Conto conto, BindingResult result){
        if(result.hasErrors()){
           throw new  RuntimeException(result.toString());
        }
        
        return contoService.addConto(conto); 
    }

    @GetMapping("/conto/{id}")
    public ContoDto conto(@PathVariable Integer id){

        return contoService.getConto(id);
    }

    @GetMapping("/allconti")
    public List<ContoDto> allConti(){
        return contoService.getAllConti();
    }

    @PutMapping("/conto")
    public ContoDto updateConto(@RequestBody ContoDto contoDto){
       
        return contoService.updateConto(contoDto);
    }

    @DeleteMapping("/conto/{id}")
    public void deleteConto(@PathVariable Integer id){

        contoService.deleteConto(id);
    }


    @PostMapping("/operation")
    public OperationDto newOperation(@RequestBody Operation operation) {
        
        return operationServiceInvernale.addOperation(operation);
    }

    @GetMapping("/operation/{id}")
    public OperationDto getOperation(@PathVariable Integer id){

        return operationServiceInvernale.getOperation(id);
    }

    @PutMapping("/operation")
    public OperationDto updateOperation(@RequestBody OperationDto operationDto){

        return operationServiceInvernale.updateOperation(operationDto);
    }

    @DeleteMapping("/operation/{id}")
    public void deleteOperation(@PathVariable Integer id){
        operationServiceInvernale.deleteOperation(id);

    }
    
    @DeleteMapping("/operation/deleteall/{id}")
    public void deleteAllOperation(@PathVariable Integer id){
        operationServiceInvernale.deleteAllOperation(id); 

    }
        
    @PostMapping("/deposito")
    public ContoDto deposito(@RequestBody @Valid Operation operation){
        OperationDto operationDto = operationServiceInvernale.addOperation(operation);
        Conto conto = operationDto.getConto();
        conto.setSaldo(conto.getSaldo() + operationDto.getAmmontare());
        ContoDto contoDto = contoConverter.entityToDto(conto);
        contoService.updateConto(contoDto);
        return contoDto;
        
    }


   

    
    
    }


 