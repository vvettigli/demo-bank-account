package contocorrente.conto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor 
@Getter @Setter
public class UserGiuridicoDto extends UserDto {
     
     String partitaIva; 

}
