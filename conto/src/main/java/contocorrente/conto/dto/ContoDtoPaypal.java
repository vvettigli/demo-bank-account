package contocorrente.conto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ContoDtoPaypal extends ContoDto {
    
    private String cartaDiCredito;
}
