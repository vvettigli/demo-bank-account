package contocorrente.conto.services;

import java.util.List;

import contocorrente.conto.dto.OperationDto;

public interface OperationService {

    public OperationDto addOperation(OperationDto operation);

    public List<OperationDto> getAllOperations();

    public OperationDto getOperation(Integer id);

    public OperationDto updateOperation(OperationDto operationDtoUpdate);

    public void deleteOperation(Integer id);

    public void deleteAllOperation (Integer id);

}
