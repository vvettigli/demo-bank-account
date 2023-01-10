package contocorrente.conto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @NotNull 
    @Column(name="operationid")
    private Integer id;
    
   @JsonBackReference
   @ManyToOne
   @Getter(AccessLevel.NONE)
   @JsonIgnoreProperties("operation")
   @JoinColumn(name = "contoid")
    private Conto conto;

    @NotNull(message = "inserire il valore")
    @Column(name="ammontare")
    private Double ammontare;
}
