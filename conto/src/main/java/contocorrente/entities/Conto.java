package contocorrente.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "OPERATIONS")
public class Conto {
    @Id
    @Column(name="ID")
    @NotNull @NotBlank @NotEmpty
    private String id;
    
    @Column(name="USER_ID")
    @NotNull @NotBlank @NotEmpty
    private String userID;
    
    @Column(name="SALDO")
    @NotNull @NotBlank @NotEmpty
    private Double saldo;
}
