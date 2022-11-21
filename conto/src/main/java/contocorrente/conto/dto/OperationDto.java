package contocorrente.conto.dto;

import contocorrente.conto.entities.Conto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OperationDto {
    Integer id;
    Conto conto;
    Double ammontare;
}
