package contocorrente.conto.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import contocorrente.conto.Converter.ContoConverter;
import contocorrente.conto.Converter.UserConverter;
import contocorrente.conto.HandleException.ApiError;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.HandleException.NullException;
import contocorrente.conto.dao.ContoRepository;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.Conto;

@Service
public class ContoServiceImpl implements ContoService {

    @Autowired
    ContoRepository contoRepository;
    @Autowired
    ContoConverter contoConverter;
    @Autowired
    UserService userService;
    @Autowired
    UserConverter userConverter;

    public ContoDto addConto(Conto conto) {

        UserDto userDto = userService.getUser(conto.getUser().getId());

        conto.setUser(userConverter.dtoToEntity(userDto));
        contoRepository.save(conto);

        return contoConverter.entityToDto(conto);
    }

    public List<ContoDto> getAllConti() {

        List<Conto> listaConto = contoRepository.findAll().stream().collect(Collectors.toList());
        if (listaConto.isEmpty()) {
            throw new NullException("non esistono conti");
        }
        return contoConverter.allEntityToDto(listaConto);

    }

    public ContoDto getConto(Integer id) {

        Conto conto = contoRepository.findById(id)
                .orElseThrow(() ->  NotFoundException.of("il conto con id " + id + " non esiste"));

        return contoConverter.entityToDto(conto);

    }

    public ContoDto updateConto(ContoDto contoDtoUpdate) {

        Conto conto = contoRepository.findById(contoDtoUpdate.getId())
                .orElseThrow(() -> NotFoundException.of("il conto con id " + contoDtoUpdate.getId() + " non esiste"));

        contoDtoUpdate.setUser(conto.getUser());
        conto = contoConverter.dtoToEntity(contoDtoUpdate);
        contoRepository.save(conto);
        return contoConverter.entityToDto(conto);

    }

    public void deleteConto(Integer id) {
        Conto contoDaEliminare = contoConverter.dtoToEntity(getConto(id));
        contoRepository.delete(contoDaEliminare);
    }

}
