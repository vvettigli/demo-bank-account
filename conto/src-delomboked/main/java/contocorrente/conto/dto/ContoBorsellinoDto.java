// Generated by delombok at Thu Jan 05 09:42:45 CET 2023
package contocorrente.conto.dto;

public class ContoBorsellinoDto extends ContoDto {
    Boolean meccanismoDiApertura;


    @java.lang.SuppressWarnings("all")
    public static abstract class ContoBorsellinoDtoBuilder<C extends ContoBorsellinoDto, B extends ContoBorsellinoDto.ContoBorsellinoDtoBuilder<C, B>> extends ContoDto.ContoDtoBuilder<C, B> {
        @java.lang.SuppressWarnings("all")
        private Boolean meccanismoDiApertura;

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        protected abstract B self();

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public abstract C build();

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public B meccanismoDiApertura(final Boolean meccanismoDiApertura) {
            this.meccanismoDiApertura = meccanismoDiApertura;
            return self();
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "ContoBorsellinoDto.ContoBorsellinoDtoBuilder(super=" + super.toString() + ", meccanismoDiApertura=" + this.meccanismoDiApertura + ")";
        }
    }


    @java.lang.SuppressWarnings("all")
    private static final class ContoBorsellinoDtoBuilderImpl extends ContoBorsellinoDto.ContoBorsellinoDtoBuilder<ContoBorsellinoDto, ContoBorsellinoDto.ContoBorsellinoDtoBuilderImpl> {
        @java.lang.SuppressWarnings("all")
        private ContoBorsellinoDtoBuilderImpl() {
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        protected ContoBorsellinoDto.ContoBorsellinoDtoBuilderImpl self() {
            return this;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public ContoBorsellinoDto build() {
            return new ContoBorsellinoDto(this);
        }
    }

    @java.lang.SuppressWarnings("all")
    protected ContoBorsellinoDto(final ContoBorsellinoDto.ContoBorsellinoDtoBuilder<?, ?> b) {
        super(b);
        this.meccanismoDiApertura = b.meccanismoDiApertura;
    }

    @java.lang.SuppressWarnings("all")
    public static ContoBorsellinoDto.ContoBorsellinoDtoBuilder<?, ?> builder() {
        return new ContoBorsellinoDto.ContoBorsellinoDtoBuilderImpl();
    }

    @java.lang.SuppressWarnings("all")
    public ContoBorsellinoDto(final Boolean meccanismoDiApertura) {
        this.meccanismoDiApertura = meccanismoDiApertura;
    }

    @java.lang.SuppressWarnings("all")
    public ContoBorsellinoDto() {
    }

    @java.lang.SuppressWarnings("all")
    public Boolean getMeccanismoDiApertura() {
        return this.meccanismoDiApertura;
    }

    @java.lang.SuppressWarnings("all")
    public void setMeccanismoDiApertura(final Boolean meccanismoDiApertura) {
        this.meccanismoDiApertura = meccanismoDiApertura;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ContoBorsellinoDto)) return false;
        final ContoBorsellinoDto other = (ContoBorsellinoDto) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (!super.equals(o)) return false;
        final java.lang.Object this$meccanismoDiApertura = this.getMeccanismoDiApertura();
        final java.lang.Object other$meccanismoDiApertura = other.getMeccanismoDiApertura();
        if (this$meccanismoDiApertura == null ? other$meccanismoDiApertura != null : !this$meccanismoDiApertura.equals(other$meccanismoDiApertura)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ContoBorsellinoDto;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final java.lang.Object $meccanismoDiApertura = this.getMeccanismoDiApertura();
        result = result * PRIME + ($meccanismoDiApertura == null ? 43 : $meccanismoDiApertura.hashCode());
        return result;
    }
}