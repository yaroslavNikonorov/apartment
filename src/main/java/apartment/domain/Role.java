package apartment.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_ANONYMOUS;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
