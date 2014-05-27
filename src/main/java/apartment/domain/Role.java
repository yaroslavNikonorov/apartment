package apartment.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    ANONIMOUSE;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
