package contocorrente.conto.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter @Setter
public class UserFisicoDto extends UserDto {

     String codiceFiscale;

}
