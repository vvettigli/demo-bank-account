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
import lombok.ToString;

@ToString
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "users")
public class user {

    @Id
    @NotEmpty @NotNull @NotBlank
    @Column(name = "ID")
    private String id;
    @NotEmpty @NotNull @NotBlank
    @Column(name = "USERNAME")
    private String username;   
    @NotEmpty @NotNull @NotBlank
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "SALDO")
    private Double saldo;
}
