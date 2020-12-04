package com.service.ticketing.models.projects.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.ticketing.models.projects.systems.SubSystem;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

public class Designer implements Serializable {
    private UUID id;
    private String name;
    private String username;
    @JsonIgnore
    private String pass;
    private String title;
    @JsonIgnore
    private UUID system;
    @JsonIgnore
    private LinkedList<UUID> issues;
    @JsonIgnore
    private String role;


    public Designer() {
        this.role = Constants.DESIGNER;
    }

    public Designer(String name, String username, String pass,UUID system ,String title) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.username = username;

        this.pass = pass;
        this.system = system;
        this.title = title;
        this.issues = new LinkedList<UUID>();
        this.role = Constants.DESIGNER;
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

    public UUID getSystem() {
        return system;
    }

    public void setSystem(UUID system) {
        this.system = system;
    }

    public void setIssues(LinkedList<UUID> issues) {
        this.issues = issues;
    }

    public String getRole() {
        return role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
