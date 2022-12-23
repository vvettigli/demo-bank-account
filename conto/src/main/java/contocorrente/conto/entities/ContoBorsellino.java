package contocorrente.conto.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class ContoBorsellino extends Conto{
    
     Boolean meccanismoDiApertura;
}
