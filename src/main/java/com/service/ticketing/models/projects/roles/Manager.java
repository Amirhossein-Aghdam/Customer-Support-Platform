package com.service.ticketing.models.projects.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.ticketing.models.projects.systems.SubSystem;

import java.io.Serializable;
import java.util.UUID;

//Project manager model
public class Manager implements Serializable {
    private UUID id;
    private String name;
    private String username;
    @JsonIgnore
    private String pass;
    private String title;
    @JsonIgnore
    private String role;
    @JsonIgnore
    private UUID system;

    public Manager() {
        this.role = Constants.MANAGER;
    }

    public Manager(String name, String username, String pass,String title ,UUID system) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.title = title;
        this.system = system;
        this.role = Constants.MANAGER;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public UUID getSystem() {
        return system;
    }

    public void setSystem(UUID system) {
        this.system = system;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
