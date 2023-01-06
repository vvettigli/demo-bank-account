package contocorrente.conto.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class ContoPaypalDto extends ContoDto {
    
     String cartaDiCredito;
}
