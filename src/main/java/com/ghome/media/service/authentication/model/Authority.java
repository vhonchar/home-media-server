package com.ghome.media.service.authentication.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "granted_authorities")
public class Authority implements GrantedAuthority, Serializable {

    @EmbeddedId
    private CompositeKey compositeKey = new CompositeKey();

    @Override
    public String getAuthority() {
        return compositeKey.getRole();
    }

    public void setUser(User user) {
        compositeKey.setUser(user);
    }

    public void setRole(String role) {
        compositeKey.setRole(role);
    }

    /*
        The only goal of this class is to create composite private key,
        so no need to make it public
     */
    @Embeddable
    private static class CompositeKey implements Serializable {

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;

        @Column
        private String role;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    @Override
    public String toString() {
        return compositeKey.getRole();
    }
}
