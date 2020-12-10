package com.service.ticketing.models.projects;

import com.service.ticketing.models.projects.roles.*;
import com.service.ticketing.models.projects.systems.SubSystem;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

public class Project implements Serializable {
    UUID id;
    LinkedList<SubSystem> subSystems;
    LinkedList<Customer> customers;
    LinkedList<Analyzer> analyzers;
    LinkedList<Designer> designers;
    LinkedList<Programmer> programmers;
    LinkedList<Manager> managers;

    public Project() {
        this.id = UUID.randomUUID();
    }

    @Autowired
    public Project(LinkedList<SubSystem> subSystems, LinkedList<Customer> customers,
                   LinkedList<Analyzer> analyzers, LinkedList<Designer> designers,
                   LinkedList<Programmer> programmers, LinkedList<Manager> managers) {
        this.subSystems = subSystems;
        this.customers = customers;
        this.analyzers = analyzers;
        this.designers = designers;
        this.programmers = programmers;
        this.managers = managers;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }


    public LinkedList<SubSystem> getSubSystems() {
        return subSystems;
    }

    public void setSubSystems(LinkedList<SubSystem> subSystems) {
        this.subSystems = subSystems;
    }

    public LinkedList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(LinkedList<Customer> customers) {
        this.customers = customers;
    }

    public LinkedList<Analyzer> getAnalyzers() {
        return analyzers;
    }

    public void setAnalyzers(LinkedList<Analyzer> analyzers) {
        this.analyzers = analyzers;
    }

    public LinkedList<Designer> getDesigners() {
        return designers;
    }

    public void setDesigners(LinkedList<Designer> designers) {
        this.designers = designers;
    }

    public LinkedList<Programmer> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(LinkedList<Programmer> programmers) {
        this.programmers = programmers;
    }

    public LinkedList<Manager> getManagers() {
        return managers;
    }

    public void setManagers(LinkedList<Manager> managers) {
        this.managers = managers;
    }
}
