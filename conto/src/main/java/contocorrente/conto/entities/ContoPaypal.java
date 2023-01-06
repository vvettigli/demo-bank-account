package contocorrente.conto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class ContoPaypal extends Conto{
    
     @Column(name = "cartadicredito")
     String cartaDiCredito;
}
