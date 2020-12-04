package com.service.ticketing.models.projects.tickets;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

//Reference model for Analyzer to refer customer Ticket to other roles
public class Reference implements Serializable {
    UUID id;
    UUID fromId;
    String toRole;
    UUID toUser;
    UUID ticketId;
    Boolean status;
    @Autowired
    LinkedList<Message> messages;

    public Reference() {
    }

    public Reference(UUID fromId, String toRole, UUID toUser, UUID ticketId, Boolean status, LinkedList<Message> messages) {
        this.id = UUID.randomUUID();
        this.fromId = fromId;
        this.toRole = toRole;
        this.toUser = toUser;
        this.ticketId = ticketId;
        this.status = status;
        this.messages = messages;
    }

    public UUID getId() {
        return id;
    }

    public UUID getFromId() {
        return fromId;
    }

    public void setFromId(UUID fromId) {
        this.fromId = fromId;
    }

    public String getToRole() {
        return toRole;
    }

    public void setToRole(String toRole) {
        this.toRole = toRole;
    }

    public UUID getToUser() {
        return toUser;
    }

    public void setToUser(UUID toUser) {
        this.toUser = toUser;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void setMessages(LinkedList<Message> messages) {
        this.messages = messages;
    }
}
