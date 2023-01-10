// Generated by delombok at Thu Jan 05 09:42:45 CET 2023
package contocorrente.conto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
// @Table(name = "usergiuridici", schema = "public")
@Entity
public class UserGiuridico extends Users {
    @Column(name = "partitaiva")
    private String partitaIva;


    @java.lang.SuppressWarnings("all")
    public static abstract class UserGiuridicoBuilder<C extends UserGiuridico, B extends UserGiuridico.UserGiuridicoBuilder<C, B>> extends Users.UsersBuilder<C, B> {
        @java.lang.SuppressWarnings("all")
        private String partitaIva;

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
        public B partitaIva(final String partitaIva) {
            this.partitaIva = partitaIva;
            return self();
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "UserGiuridico.UserGiuridicoBuilder(super=" + super.toString() + ", partitaIva=" + this.partitaIva + ")";
        }
    }


    @java.lang.SuppressWarnings("all")
    private static final class UserGiuridicoBuilderImpl extends UserGiuridico.UserGiuridicoBuilder<UserGiuridico, UserGiuridico.UserGiuridicoBuilderImpl> {
        @java.lang.SuppressWarnings("all")
        private UserGiuridicoBuilderImpl() {
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        protected UserGiuridico.UserGiuridicoBuilderImpl self() {
            return this;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public UserGiuridico build() {
            return new UserGiuridico(this);
        }
    }

    @java.lang.SuppressWarnings("all")
    protected UserGiuridico(final UserGiuridico.UserGiuridicoBuilder<?, ?> b) {
        super(b);
        this.partitaIva = b.partitaIva;
    }

    @java.lang.SuppressWarnings("all")
    public static UserGiuridico.UserGiuridicoBuilder<?, ?> builder() {
        return new UserGiuridico.UserGiuridicoBuilderImpl();
    }

    @java.lang.SuppressWarnings("all")
    public String getPartitaIva() {
        return this.partitaIva;
    }

    @java.lang.SuppressWarnings("all")
    public void setPartitaIva(final String partitaIva) {
        this.partitaIva = partitaIva;
    }

    @java.lang.SuppressWarnings("all")
    public UserGiuridico() {
    }

    @java.lang.SuppressWarnings("all")
    public UserGiuridico(final String partitaIva) {
        this.partitaIva = partitaIva;
    }
}