package contocorrente.conto.entities;

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
import lombok.ToString;

@ToString
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "users")
public class User {

    @Id
    @NotNull 
    @Column(name = "userid")
    private Integer id;
    
    @NotEmpty @NotNull @NotBlank
    @Column(name = "username")
    private String userName;
    
    @NotEmpty @NotNull @NotBlank
    @Column(name = "password")
    private String password;

    
}
