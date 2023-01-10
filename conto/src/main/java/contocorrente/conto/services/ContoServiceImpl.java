package contocorrente.conto.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.HandleException.AlreadyExistsException;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.HandleException.NullException;
import contocorrente.conto.dao.ContoBancaRepository;
import contocorrente.conto.dao.ContoBorsellinoRepository;
import contocorrente.conto.dao.ContoPaypalRepository;
import contocorrente.conto.dao.ContoRepository;
import contocorrente.conto.dto.ContoBancaDto;
import contocorrente.conto.dto.ContoBorsellinoDto;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.ContoPaypalDto;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.entities.Conto;
import contocorrente.conto.entities.ContoBanca;
import contocorrente.conto.entities.ContoBorsellino;
import contocorrente.conto.entities.ContoPaypal;

@Transactional
@Service
public class ContoServiceImpl implements ContoService {

    @Autowired
    ContoRepository contoRepository;
    @Autowired
    ContoBancaRepository contoBancaRepository;
    @Autowired
    ContoPaypalRepository contoPaypalRepository;
    @Autowired
    ContoBorsellinoRepository contoBorsellinoRepository;
    @Autowired
    UserService userService;
    @Autowired
    EntityToDtoMapper converter;

    @Override
    public ContoDto addConto(ContoDto contoDto) {

        UserDto userDto = userService.getUser(contoDto.getUserDto().getId());
        List<ContoDto> listaConto = getAllConti();
        if (listaConto != null) {
            for (int i = 0; i < listaConto.size(); i++) {
                ContoDto contoDaConvalidare = listaConto.get(i);

                if (contoDto.getId() == contoDaConvalidare.getId()) {
                    throw new AlreadyExistsException("il conto con {} è gia esistente");

                }
            }
        }

        
        contoDto.setUserDto((userDto));
        Conto conto = converter.contoDtoToConto(contoDto);
        contoRepository.save(conto);

        return converter.contoToContoDto(conto);
    }

    @Override
    public ContoBancaDto addConto(ContoBancaDto contoBancaDto) {

        UserDto userDto = userService.getUser(contoBancaDto.getUserDto().getId());
        List<ContoDto> listaConto = getAllConti();
        if (listaConto != null) {
            for (int i = 0; i < listaConto.size(); i++) {
                ContoDto contoDaConvalidare = listaConto.get(i);

                if (contoBancaDto.getId() == contoDaConvalidare.getId()) {
                    throw new AlreadyExistsException("il conto con {} è gia esistente");

                }
            }
        }

        contoBancaDto.setUserDto(userDto);
        ContoBanca contoBanca = converter.contoBancaDtoToContoBanca(contoBancaDto);
        contoBancaRepository.save(contoBanca);

        return converter.contoBancaToContoBancaDto(contoBanca);
    }

    @Override
    public ContoBorsellinoDto addConto(ContoBorsellinoDto contoBorsellinoDto) {

        UserDto userDto = userService.getUser(contoBorsellinoDto.getUserDto().getId());
        List<ContoDto> listaConto = getAllConti();
        if (listaConto != null) {
            for (int i = 0; i < listaConto.size(); i++) {
                ContoDto contoDaConvalidare = listaConto.get(i);

                if (contoBorsellinoDto.getId() == contoDaConvalidare.getId()) {
                    throw new AlreadyExistsException("il conto con {} è gia esistente");

                }
            }
        }

        contoBorsellinoDto.setUserDto((userDto));
        ContoBorsellino contoBorsellino = converter.contoBorsellinoDtoToContoBorsellino(contoBorsellinoDto);
        contoBorsellinoRepository.save(contoBorsellino);

        return converter.contoBorsellinoToContoBorsellinoDto(contoBorsellino);

    }

    @Override
    public ContoPaypalDto addConto(ContoPaypalDto contoPaypalDto) {

        UserDto userDto = userService.getUser(contoPaypalDto.getUserDto().getId());
        List<ContoDto> listaConto = getAllConti();
        if (listaConto != null) {
            for (int i = 0; i < listaConto.size(); i++) {
                ContoDto contoDaConvalidare = listaConto.get(i);

                if (contoPaypalDto.getId() == contoDaConvalidare.getId()) {
                    throw new AlreadyExistsException("il conto con {} è gia esistente");

                }
            }
        }

        contoPaypalDto.setUserDto(userDto);
        ContoPaypal contoPaypal = converter.contoPaypaDtolToContoPaypal(contoPaypalDto);
        contoPaypalRepository.save(contoPaypal);

        return converter.contoPaypalToContoPaypalDto(contoPaypal);

    }

    public List<ContoDto> getAllConti() {

        List<Conto> listaConto = contoRepository.findAll().stream().collect(Collectors.toList());
        // if (listaConto.isEmpty()) {
        //     throw new NullException("non esistono conti");
        // }
        return converter.allContoEntitiesToContoDto(listaConto);

    }

    public <T extends ContoDto> T getConto(Integer id) {

        Conto conto = contoRepository.findById(id)
                .orElseThrow(() -> NotFoundException.of("il conto con id " + id + " non esiste"));
        if (ContoBanca.class.isAssignableFrom(conto.getClass())) {
            return (T) converter.contoBancaToContoBancaDto(ContoBanca.class.cast(conto));
        } else if (ContoBorsellino.class.isAssignableFrom(conto.getClass())) {
            return (T) converter.contoBorsellinoToContoBorsellinoDto(ContoBorsellino.class.cast(conto));
        } else if (ContoPaypal.class.isAssignableFrom(conto.getClass())) {
            return (T) converter.contoPaypalToContoPaypalDto(ContoPaypal.class.cast(conto));
        } else {
            return (T) converter.contoToContoDto(conto);
        }

    }

    public ContoDto updateConto(ContoDto contoDtoUpdate) {

        Conto conto = contoRepository.findById(contoDtoUpdate.getId())
                .orElseThrow(() -> NotFoundException.of("il conto con id " + contoDtoUpdate.getId() + " non esiste"));

        ContoDto contoDto = converter.contoToContoDto(conto);
        contoDtoUpdate.setUserDto(contoDto.getUserDto());
        conto = converter.contoDtoToConto(contoDtoUpdate);
        contoRepository.save(conto);
        return converter.contoToContoDto(conto);

    }

    @Override
    public ContoBancaDto updateConto(ContoBancaDto contoBancaDtoUpdate) {
        ContoBanca contoBanca = contoBancaRepository.findById(contoBancaDtoUpdate.getId())
                .orElseThrow(
                        () -> NotFoundException.of("il conto con id " + contoBancaDtoUpdate.getId() + " non esiste"));

        ContoBancaDto contoBancaDto = converter.contoBancaToContoBancaDto(contoBanca);
        contoBancaDtoUpdate.setUserDto(contoBancaDto.getUserDto());
        contoBanca = converter.contoBancaDtoToContoBanca(contoBancaDtoUpdate);
        contoBancaRepository.save(contoBanca);
        return converter.contoBancaToContoBancaDto(contoBanca);
    }

    @Override
    public ContoBorsellinoDto updateConto(ContoBorsellinoDto contoBorsellinoDtoUpdate) {

        ContoBorsellino contoBorsellino = contoBorsellinoRepository.findById(contoBorsellinoDtoUpdate.getId())
                .orElseThrow(
                        () -> NotFoundException
                                .of("il conto con id " + contoBorsellinoDtoUpdate.getId() + " non esiste"));

        ContoBorsellinoDto contoBancaDto = converter.contoBorsellinoToContoBorsellinoDto(contoBorsellino);
        contoBorsellinoDtoUpdate.setUserDto(contoBancaDto.getUserDto());
        contoBorsellino = converter.contoBorsellinoDtoToContoBorsellino(contoBorsellinoDtoUpdate);
        contoBorsellinoRepository.save(contoBorsellino);
        return converter.contoBorsellinoToContoBorsellinoDto(contoBorsellino);
    }

    @Override
    public ContoPaypalDto updateConto(ContoPaypalDto contoPaypalDtoUpdate) {
        ContoPaypal contoPaypal = contoPaypalRepository.findById(contoPaypalDtoUpdate.getId())
                .orElseThrow(
                        () -> NotFoundException
                                .of("il conto con id " + contoPaypalDtoUpdate.getId() + " non esiste"));

        ContoPaypalDto contoPaypalDto = converter.contoPaypalToContoPaypalDto(contoPaypal);
        contoPaypalDtoUpdate.setUserDto(contoPaypalDto.getUserDto());
        contoPaypal = converter.contoPaypaDtolToContoPaypal(contoPaypalDtoUpdate);
        contoPaypalRepository.save(contoPaypal);
        return converter.contoPaypalToContoPaypalDto(contoPaypal);
    }

    public <T extends ContoDto> void deleteConto(Integer id) {
        T contoDaEliminare = getConto(id);
       
        if (ContoBanca.class.isAssignableFrom(contoDaEliminare.getClass())) {
            ContoBanca contoBanca = converter.contoBancaDtoToContoBanca(ContoBancaDto.class.cast(contoDaEliminare));
            contoBancaRepository.delete(contoBanca);
        } else if (ContoBorsellino.class.isAssignableFrom(contoDaEliminare.getClass())) {
            ContoBorsellino contoBorsellino = converter.contoBorsellinoDtoToContoBorsellino(ContoBorsellinoDto.class.cast(contoDaEliminare));
            contoBorsellinoRepository.delete(contoBorsellino);
        } else if (ContoPaypal.class.isAssignableFrom(contoDaEliminare.getClass())) {
            ContoPaypal contoPaypal = converter.contoPaypaDtolToContoPaypal(ContoPaypalDto.class.cast(contoDaEliminare));
            contoPaypalRepository.delete(contoPaypal);
        } else {
            Conto conto = converter.contoDtoToConto(contoDaEliminare);
            contoRepository.delete(conto);
        }
    }

}
