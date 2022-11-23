package contocorrente.conto.dto;

import contocorrente.conto.entities.Conto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor


public class OperationDto {
    Integer id;
    Conto conto;
    Double ammontare;
}
