package contocorrente.conto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "users", schema = "public")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public class Users {

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
