package com.service.ticketing.models.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.UUID;

//An instance of this class is generated by loadByUsername method
public class User {
    private String username;
    private String password;
    private Collection<GrantedAuthority> roles;
    private UUID id;
    private UUID system;

    public User(String username, String password, Collection<GrantedAuthority> authorities, UUID id, UUID system) {
        this.username = username;
        this.password = password;
        this.roles = authorities;
        this.id=id;
        this.system=system;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Collection<GrantedAuthority> getRoles() {
        return roles;
    }

    public UUID getId() {
        return id;
    }

    public UUID getSystem() {
        return system;
    }

    public void setSystem(UUID system) {
        this.system = system;
    }
}
