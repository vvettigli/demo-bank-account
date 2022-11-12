package contocorrente.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "OPERATIONS")
public class Operation {
    @Id
    @Column(name="ID")
    @NotNull @NotBlank @NotEmpty
    private String id;
    
    @Column(name="USER_ID")
    @NotNull @NotBlank @NotEmpty
    private String userID;
    
    @Column(name="VALORE")
    @NotNull @NotBlank @NotEmpty
    private Double valore;
}
