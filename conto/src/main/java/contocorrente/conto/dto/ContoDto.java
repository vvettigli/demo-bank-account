package contocorrente.conto.dto;

import java.util.Set;

import contocorrente.conto.entities.Operation;
import contocorrente.conto.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContoDto {
    Integer id;
    User user;
    Double saldo;
    Set<Operation> operation;
    
}
