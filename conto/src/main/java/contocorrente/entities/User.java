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
import lombok.ToString;

@ToString
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "USERS")
public class User {

	@NotEmpty @NotNull @NotBlank
    @Id
    @Column(name = "ID")
    private String id;
    
    @NotEmpty @NotNull @NotBlank
    @Column(name = "USERNAME")
    private String userName;
    
    @NotEmpty @NotNull @NotBlank
    @Column(name = "PASSWORD")
    private String password;
}
