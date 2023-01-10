// Generated by delombok at Thu Jan 05 09:42:45 CET 2023
package contocorrente.conto.dto;

import lombok.Builder;

public class UserDto {
    Integer id;
    String userName;
    String password;


    @java.lang.SuppressWarnings("all")
    public static abstract class UserDtoBuilder<C extends UserDto, B extends UserDto.UserDtoBuilder<C, B>> {
        @java.lang.SuppressWarnings("all")
        private Integer id;
        @java.lang.SuppressWarnings("all")
        private String userName;
        @java.lang.SuppressWarnings("all")
        private String password;

        @java.lang.SuppressWarnings("all")
        protected abstract B self();

        @java.lang.SuppressWarnings("all")
        public abstract C build();

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public B id(final Integer id) {
            this.id = id;
            return self();
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public B userName(final String userName) {
            this.userName = userName;
            return self();
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public B password(final String password) {
            this.password = password;
            return self();
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "UserDto.UserDtoBuilder(id=" + this.id + ", userName=" + this.userName + ", password=" + this.password + ")";
        }
    }


    @java.lang.SuppressWarnings("all")
    private static final class UserDtoBuilderImpl extends UserDto.UserDtoBuilder<UserDto, UserDto.UserDtoBuilderImpl> {
        @java.lang.SuppressWarnings("all")
        private UserDtoBuilderImpl() {
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        protected UserDto.UserDtoBuilderImpl self() {
            return this;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public UserDto build() {
            return new UserDto(this);
        }
    }

    @java.lang.SuppressWarnings("all")
    protected UserDto(final UserDto.UserDtoBuilder<?, ?> b) {
        this.id = b.id;
        this.userName = b.userName;
        this.password = b.password;
    }

    @java.lang.SuppressWarnings("all")
    public static UserDto.UserDtoBuilder<?, ?> builder() {
        return new UserDto.UserDtoBuilderImpl();
    }

    @java.lang.SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @java.lang.SuppressWarnings("all")
    public String getUserName() {
        return this.userName;
    }

    @java.lang.SuppressWarnings("all")
    public String getPassword() {
        return this.password;
    }

    @java.lang.SuppressWarnings("all")
    public void setId(final Integer id) {
        this.id = id;
    }

    @java.lang.SuppressWarnings("all")
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @java.lang.SuppressWarnings("all")
    public void setPassword(final String password) {
        this.password = password;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDto)) return false;
        final UserDto other = (UserDto) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$id = this.getId();
        final java.lang.Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final java.lang.Object this$userName = this.getUserName();
        final java.lang.Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final java.lang.Object this$password = this.getPassword();
        final java.lang.Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof UserDto;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final java.lang.Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final java.lang.Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    @java.lang.SuppressWarnings("all")
    public UserDto(final Integer id, final String userName, final String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    @java.lang.SuppressWarnings("all")
    public UserDto() {
    }
}