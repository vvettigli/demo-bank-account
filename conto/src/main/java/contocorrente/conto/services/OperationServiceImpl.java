package contocorrente.conto.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.HandleException.NullException;
import contocorrente.conto.dao.OperationRepository;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.entities.Operation;

@Transactional
@Service
public class OperationServiceImpl implements OperationService {

    private static Logger logger = LoggerFactory.getLogger(OperationServiceImpl.class);
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    ContoService contoService;
    @Autowired
    EntityToDtoMapper converter;

    public OperationDto addOperation(OperationDto operationDto) {
        logger.debug("addOperation start");
        ContoDto contoDto = contoService.getConto(operationDto.getContoDto().getId());
        Operation operation = converter.operationDtoToOperation(operationDto);
        operation.setConto(converter.contoDtoToConto(contoDto));
        operationRepository.save(operation);
        logger.debug("addOperation end");
        return converter.operationToOperationDto(operation);
    }

    public List<OperationDto> getAllOperations() {
        List<Operation> listaOperation = operationRepository.findAll().stream().collect(Collectors.toList());
        if (listaOperation.isEmpty()) {
            throw new NullException("non esistono conti");
        }
        return converter.allOperationEntitiesToOperationDto(listaOperation);
    }

    public OperationDto getOperation(Integer id) {
        logger.debug("getOperation start");

        Operation operation = operationRepository.findById(id)
                .orElseThrow(() ->  NotFoundException.of("l'operazione con id " + id + " non esiste"));

        return converter.operationToOperationDto(operation);

    }

    public OperationDto updateOperation(OperationDto operationDtoUpdate) {
        Operation operation = operationRepository.findById(operationDtoUpdate.getId())
                .orElseThrow(() -> NotFoundException.of("l'operazione con id " + operationDtoUpdate.getId() + " non esiste"));
        OperationDto operationDto = converter.operationToOperationDto(operation);
        operationDtoUpdate.setContoDto(operationDto.getContoDto());
        operation = converter.operationDtoToOperation(operationDtoUpdate);
        operationRepository.save(operation);
        return converter.operationToOperationDto(operation);

    }

    public void deleteOperation(Integer id) {
        logger.debug("deleteOperation start");
        Operation operationDaEliminare = converter.operationDtoToOperation(getOperation(id));
        operationRepository.delete(operationDaEliminare);
        logger.debug("deleteOperation end");

    }

    public void deleteAllOperation (Integer id){
       
        
    }

}
