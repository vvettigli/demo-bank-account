package contocorrente.conto.dto;

import java.util.Set;

import contocorrente.conto.entities.Operation;
import contocorrente.conto.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class ContoDto {
    Integer id;
    User user;
    Double saldo;
    Set<Operation> operation;
    
}
