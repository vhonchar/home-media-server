package com.ghome.media.service.authentication.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "granted_authorities")
public class Authority implements GrantedAuthority, Serializable {

    @EmbeddedId
    private CompositeKey compositeKey = new CompositeKey();

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Authority() {
    }

    public Authority(User user, String role) {
        compositeKey.setRole(role);
        compositeKey.setUserId(user.getId());
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return compositeKey.getRole();
    }

    public void setRole(String role) {
        compositeKey.setRole(role);
    }

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(CompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Embeddable
    public static class CompositeKey implements Serializable {

        @Column(name = "user_id")
        private Long userId;

        @Column
        private String role;

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CompositeKey that = (CompositeKey) o;

            if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
            return !(role != null ? !role.equals(that.role) : that.role != null);

        }

        @Override
        public int hashCode() {
            int result = userId != null ? userId.hashCode() : 0;
            result = 31 * result + (role != null ? role.hashCode() : 0);
            return result;
        }
    }

}
