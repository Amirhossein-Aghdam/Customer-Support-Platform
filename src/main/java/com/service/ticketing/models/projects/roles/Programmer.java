package com.service.ticketing.models.projects.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.ticketing.models.projects.systems.SubSystem;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

//Programmer Role model class
public class Programmer implements Serializable {

    private UUID id;
    private String name;
    private String username;
    @JsonIgnore
    private String pass;
    @JsonIgnore
    private UUID system;
    private String title;
    @JsonIgnore
    private LinkedList<UUID> issues;
    @JsonIgnore
    private String role;

    public Programmer() {
        this.role = Constants.PROGRAMMER;
    }

    @Autowired
    public Programmer(String name, String username, String pass,UUID system ,String title) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.system = system;
        this.title = title;
        this.issues = new LinkedList<UUID>();
        this.role = Constants.PROGRAMMER;
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

    public LinkedList<UUID> getIssues() {
        return issues;
    }

    public void setIssues(LinkedList<UUID> issues) {
        this.issues = issues;
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
