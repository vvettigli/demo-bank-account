package contocorrente.conto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "userfisici", schema = "public")
public class UserFisico extends Users {

    
    @Column(name ="codicefiscale")
    private String codiceFiscale;

    

}
