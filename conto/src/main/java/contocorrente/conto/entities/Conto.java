package contocorrente.conto.entities;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "conti")
public class Conto {
    @Id
    @NotNull 
    @Column(name = "contoid")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "saldo")
    @NotNull(message = "inserire il saldo")
    private Double saldo;

    @OneToMany(
        mappedBy = "conto",
        fetch = FetchType.LAZY)
    private Set<Operation> operation;

}