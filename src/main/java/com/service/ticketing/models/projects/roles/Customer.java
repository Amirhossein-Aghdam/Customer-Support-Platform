package com.service.ticketing.models.projects.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.ticketing.models.projects.tickets.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

//Customer role model class
public class Customer implements Serializable {
    private UUID id;
    private String name;
    private String username;
    @JsonIgnore
    private String pass;
    private String title;
    @JsonIgnore
    private UUID system;
    @JsonIgnore
    private LinkedList<Ticket> issues;
    @JsonIgnore
    private String role;

    public Customer() {
        this.role = Constants.CUSTOMER;
    }

    @Autowired
    public Customer(String name, String username, String pass,
                    String title ,UUID system) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.title = title;
        this.system = system;
        this.issues = new LinkedList<Ticket>();
        this.role = Constants.CUSTOMER;
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

    public UUID getSystem() {
        return system;
    }

    public void setSystem(UUID system) {
        this.system = system;
    }

    public LinkedList<Ticket> getIssues() {
        return issues;
    }

    public void setIssues(LinkedList<Ticket> issues) {
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
