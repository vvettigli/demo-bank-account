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
public class ContoBorsellinoDto extends ContoDto {
    
     Boolean meccanismoDiApertura;
}
