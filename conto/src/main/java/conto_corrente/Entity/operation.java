package conto_corrente.Entity;

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
@Table(name = "operation")
public class operation {
    @Id
    @Column(name="ID")
    @NotNull @NotBlank @NotEmpty
    private String id;
    @Column(name="IDUSER1")
    @NotNull @NotBlank @NotEmpty
    private String idUser1;
    @Column(name="VALORE")
    @NotNull @NotBlank @NotEmpty
    private Double valore;
}
