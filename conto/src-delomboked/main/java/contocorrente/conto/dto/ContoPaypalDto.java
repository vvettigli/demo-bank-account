// Generated by delombok at Thu Jan 05 09:42:45 CET 2023
package contocorrente.conto.dto;

public class ContoPaypalDto extends ContoDto {
    String cartaDiCredito;


    @java.lang.SuppressWarnings("all")
    public static abstract class ContoPaypalDtoBuilder<C extends ContoPaypalDto, B extends ContoPaypalDto.ContoPaypalDtoBuilder<C, B>> extends ContoDto.ContoDtoBuilder<C, B> {
        @java.lang.SuppressWarnings("all")
        private String cartaDiCredito;

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
        public B cartaDiCredito(final String cartaDiCredito) {
            this.cartaDiCredito = cartaDiCredito;
            return self();
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "ContoPaypalDto.ContoPaypalDtoBuilder(super=" + super.toString() + ", cartaDiCredito=" + this.cartaDiCredito + ")";
        }
    }


    @java.lang.SuppressWarnings("all")
    private static final class ContoPaypalDtoBuilderImpl extends ContoPaypalDto.ContoPaypalDtoBuilder<ContoPaypalDto, ContoPaypalDto.ContoPaypalDtoBuilderImpl> {
        @java.lang.SuppressWarnings("all")
        private ContoPaypalDtoBuilderImpl() {
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        protected ContoPaypalDto.ContoPaypalDtoBuilderImpl self() {
            return this;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public ContoPaypalDto build() {
            return new ContoPaypalDto(this);
        }
    }

    @java.lang.SuppressWarnings("all")
    protected ContoPaypalDto(final ContoPaypalDto.ContoPaypalDtoBuilder<?, ?> b) {
        super(b);
        this.cartaDiCredito = b.cartaDiCredito;
    }

    @java.lang.SuppressWarnings("all")
    public static ContoPaypalDto.ContoPaypalDtoBuilder<?, ?> builder() {
        return new ContoPaypalDto.ContoPaypalDtoBuilderImpl();
    }

    @java.lang.SuppressWarnings("all")
    public ContoPaypalDto(final String cartaDiCredito) {
        this.cartaDiCredito = cartaDiCredito;
    }

    @java.lang.SuppressWarnings("all")
    public ContoPaypalDto() {
    }

    @java.lang.SuppressWarnings("all")
    public String getCartaDiCredito() {
        return this.cartaDiCredito;
    }

    @java.lang.SuppressWarnings("all")
    public void setCartaDiCredito(final String cartaDiCredito) {
        this.cartaDiCredito = cartaDiCredito;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ContoPaypalDto)) return false;
        final ContoPaypalDto other = (ContoPaypalDto) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (!super.equals(o)) return false;
        final java.lang.Object this$cartaDiCredito = this.getCartaDiCredito();
        final java.lang.Object other$cartaDiCredito = other.getCartaDiCredito();
        if (this$cartaDiCredito == null ? other$cartaDiCredito != null : !this$cartaDiCredito.equals(other$cartaDiCredito)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ContoPaypalDto;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final java.lang.Object $cartaDiCredito = this.getCartaDiCredito();
        result = result * PRIME + ($cartaDiCredito == null ? 43 : $cartaDiCredito.hashCode());
        return result;
    }
}
