// Generated by delombok at Thu Jan 05 09:42:45 CET 2023
package contocorrente.conto.dto;

import contocorrente.conto.entities.Conto;

public class OperationDto {
    Integer id;
    Conto conto;
    Double ammontare;

    @java.lang.SuppressWarnings("all")
    public void setId(final Integer id) {
        this.id = id;
    }

    @java.lang.SuppressWarnings("all")
    public void setConto(final Conto conto) {
        this.conto = conto;
    }

    @java.lang.SuppressWarnings("all")
    public void setAmmontare(final Double ammontare) {
        this.ammontare = ammontare;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @java.lang.SuppressWarnings("all")
    public Conto getConto() {
        return this.conto;
    }

    @java.lang.SuppressWarnings("all")
    public Double getAmmontare() {
        return this.ammontare;
    }

    @java.lang.SuppressWarnings("all")
    public OperationDto(final Integer id, final Conto conto, final Double ammontare) {
        this.id = id;
        this.conto = conto;
        this.ammontare = ammontare;
    }

    @java.lang.SuppressWarnings("all")
    public OperationDto() {
    }
}