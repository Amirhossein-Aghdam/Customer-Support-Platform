package com.service.ticketing.models.projects.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.ticketing.models.projects.systems.SubSystem;
import com.service.ticketing.models.projects.tickets.Reference;
import com.service.ticketing.models.projects.tickets.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

//Analyzer model class whose task is to direct issues into
//appropriate roles
public class Analyzer implements Serializable {
    private UUID id;
    private String name;
    private String username;
    @JsonIgnore
    private String pass;
    private String title;
    @JsonIgnore
    private UUID system;
    @JsonIgnore
    private LinkedList<UUID> userReports;
    @JsonIgnore
    private LinkedList<Reference> referrals;
    @JsonIgnore
    private LinkedList<Ticket> issues;
    @JsonIgnore
    private String role;

    public Analyzer() {
        this.role = Constants.ANALYSER;
    }

    @Autowired
    public Analyzer(String name, String username, String pass, String title, UUID system) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.title = title;
        this.system = system;
        this.userReports = new LinkedList<UUID>();
        this.referrals = new LinkedList<Reference>();
        this.issues = new LinkedList<Ticket>();
        this.role = Constants.ANALYSER;
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

    public LinkedList<UUID> getUserReports() {
        return userReports;
    }

    public void setUserReports(LinkedList<UUID> userReports) {
        this.userReports = userReports;
    }

    public LinkedList<Reference> getReferrals() {
        return referrals;
    }

    public void setReferrals(LinkedList<Reference> referrals) {
        this.referrals = referrals;
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
