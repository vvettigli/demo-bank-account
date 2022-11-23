package contocorrente.conto.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.conto.Converter.ContoConverter;
import contocorrente.conto.Converter.OperationConverter;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.HandleException.NullException;
import contocorrente.conto.dao.OperationRepository;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.entities.Operation;

@Service
public class OperationService {

    private static Logger logger = LoggerFactory.getLogger(OperationService.class);
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    OperationConverter operationConverter;
    @Autowired
    ContoService contoService;
    @Autowired
    ContoConverter contoConverter;

    public OperationDto addOperation(Operation operation) {
        logger.debug("addOperation start");
        ContoDto contoDto = contoService.getConto(operation.getConto().getId());
        operation.setConto(contoConverter.dtoToEntity(contoDto));
        operationRepository.save(operation);
        logger.debug("addOperation end");
        return operationConverter.entityToDto(operation);
    }

    public List<OperationDto> getAllOperations() {
        List<Operation> listaOperation = operationRepository.findAll().stream().collect(Collectors.toList());
        if (listaOperation.isEmpty()) {
            throw new NullException("non esistono conti");
        }
        return operationConverter.allEntityToDto(listaOperation);
    }
    //NON SO DOVE METTERE logger.debug("addOperation end");

    public OperationDto getOperation(Integer id) {
        logger.debug("getOperation start");

        Operation operation = operationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("l'operazione con id " + id + " non esiste"));

        return operationConverter.entityToDto(operation);

    }

    public OperationDto updateOperation(OperationDto operationDtoUpdate) {
        Operation operation = operationRepository.findById(operationDtoUpdate.getId())
                .orElseThrow(() -> new NotFoundException("l'operazione con id " + operationDtoUpdate.getId() + " non esiste"));

        operationDtoUpdate.setConto(operation.getConto());
        operation = operationConverter.dtoToEntity(operationDtoUpdate);
        operationRepository.save(operation);
        return operationConverter.entityToDto(operation);

    }

    public void deleteOperation(Integer id) {
        logger.debug("deleteOperation start");
        Operation operationDaEliminare = operationConverter.dtoToEntity(getOperation(id));
        operationRepository.delete(operationDaEliminare);
        logger.debug("deleteOperation end");

    }

}
