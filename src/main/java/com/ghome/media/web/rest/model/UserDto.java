package com.ghome.media.web.rest.model;

import java.util.List;

public class UserDto {

    private String id;
    private String login;
    private List<String> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
