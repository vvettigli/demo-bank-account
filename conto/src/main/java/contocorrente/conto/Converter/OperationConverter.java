package contocorrente.conto.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.entities.Operation;
@Component
public class OperationConverter {


    public OperationDto entityToDto(Operation operation){

        OperationDto dto = new OperationDto();
        dto.setId(operation.getId());
        dto.setConto(operation.getConto());
        dto.setAmmontare(operation.getAmmontare());
        return dto;

    }

    public Operation dtoToEntity(OperationDto dto){

        Operation operation = new Operation();
        operation.setId(dto.getId());
        operation.setConto(dto.getConto());
        operation.setAmmontare(dto.getAmmontare());
        return operation;
    }

    public List<OperationDto> allEntityToDto(List<Operation> Operation){
        return Operation.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public List<Operation> allDtoToEntity(List<OperationDto> OperationDto){
        return OperationDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
