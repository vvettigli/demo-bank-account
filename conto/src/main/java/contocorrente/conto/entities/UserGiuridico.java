package contocorrente.conto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
// @Table(name = "usergiuridici", schema = "public")
public class UserGiuridico extends Users {


    @Column(name = "partitaiva")
    private String partitaIva;

    

}
