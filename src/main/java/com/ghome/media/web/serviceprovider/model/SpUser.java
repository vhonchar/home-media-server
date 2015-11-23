package com.ghome.media.web.serviceprovider.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public class SpUser implements Serializable, Authentication{

    private Collection<GrantedAuthority> grantedAuthorities;
    private String creationDate;
    private String ttl;
    private String name;
    private boolean authenticated;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated = b;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public void setName(String name) {
        this.name = name;
    }
}
