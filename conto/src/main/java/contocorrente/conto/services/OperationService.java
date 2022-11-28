package contocorrente.conto.services;

import java.util.List;

import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.entities.Operation;

public interface OperationService {

    public OperationDto addOperation(Operation operation);

    public List<OperationDto> getAllOperations();

    public OperationDto getOperation(Integer id);

    public OperationDto updateOperation(OperationDto operationDtoUpdate);

    public void deleteOperation(Integer id);

    public void deleteAllOperation (Integer id);

}
