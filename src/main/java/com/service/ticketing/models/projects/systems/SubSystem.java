package com.service.ticketing.models.projects.systems;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.UUID;

public class SubSystem implements Serializable {
    @Autowired
    UUID id;
    String name;
    Boolean completed;

    public SubSystem(String name, Boolean completed) {
        this.id=UUID.randomUUID();
        this.name = name;
        this.completed = completed;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
