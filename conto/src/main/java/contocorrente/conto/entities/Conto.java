package contocorrente.conto.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

@Table(name = "conti")
public class Conto {
    @Id
    @NotNull 
    @Column(name = "contoid")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    @Column(name = "saldo")
    @NotNull(message = "inserire il saldo")
    private Double saldo;

    @ToString.Exclude
    @JsonManagedReference
    @JsonIgnoreProperties("conto")
    @OneToMany(
        mappedBy = "conto",
        fetch = FetchType.EAGER)
    private Set<Operation> operation;

}
