package contocorrente.conto.dto;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode

public class OperationDto {
    Integer id;
    Double ammontare;
    
    
    ContoDto contoDto;

}
