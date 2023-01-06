package contocorrente.conto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter @Setter @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor 
public class UserDto {
    Integer id;
    String userName;
    String password;
}
