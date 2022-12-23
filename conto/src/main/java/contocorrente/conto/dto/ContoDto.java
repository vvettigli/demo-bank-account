package contocorrente.conto.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class ContoDto {
    Integer id;
    UserDto userDto;
    Double saldo;
    Set<OperationDto> operationDto;
    
}
