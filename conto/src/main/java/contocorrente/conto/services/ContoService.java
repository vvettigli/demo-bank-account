package contocorrente.conto.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.conto.Converter.ContoConverter;
import contocorrente.conto.Converter.UserConverter;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.dao.ContoRepository;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.Conto;
import contocorrente.conto.entities.User;

@Service
public class ContoService {


    @Autowired
    ContoRepository contoRepository;
    @Autowired
    ContoConverter contoConverter;
    @Autowired
    UserService userService;
    @Autowired
    UserConverter userConverter;

    public ContoDto addConto(Conto conto){

        UserDto userDto = userService.getUser(conto.getUser().getId());
        conto.setUser(userConverter.dtoToEntity(userDto)); 
        contoRepository.save(conto);

        return contoConverter.entityToDto(conto);
    }

    public List<ContoDto> getAllConti(){

         List<Conto> listaConto = contoRepository.findAll().stream().collect(Collectors.toList());

         return contoConverter.allEntityToDto(listaConto);
        
    }
    public ContoDto getConto(Integer id){

        Conto conto = contoRepository.findById(id).orElseThrow(() -> new NotFoundException("il conto con id " + id + " non esiste"));
        
            return contoConverter.entityToDto(conto);
            
        }

        //NON FUNZIONA
    public ContoDto updateConto(Integer id, Conto contoUpdate){
        ContoDto contoDto = getConto(id);
        Conto conto = contoConverter.dtoToEntity(contoDto);
        conto = contoUpdate;
        contoRepository.save(conto);
        return contoConverter.entityToDto(conto);
       
    }
    public void deleteContoById(Integer id){
        contoRepository.deleteById(id);
    }
    
}
