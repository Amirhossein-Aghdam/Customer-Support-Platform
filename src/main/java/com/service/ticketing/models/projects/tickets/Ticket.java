package com.service.ticketing.models.projects.tickets;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

//Model class of an issued ticket
public class Ticket implements Serializable {
    UUID id;
    String issueTitle;
    Boolean status;
    String system;
    Date openedDate;
    Date closedDate;
    UUID openedBy;
    UUID closeBy;
    LinkedList<Message> messages;

    public Ticket() {
    }

    public Ticket(UUID id, String issueTitle, Boolean status, String system, Date openedDate,
                  Date closedDate, UUID openedBy, UUID closeBy, LinkedList<Message> messages) {
        this.id = id;
        this.issueTitle = issueTitle;
        this.status = status;
        this.system = system;
        this.openedDate = openedDate;
        this.closedDate = closedDate;
        this.openedBy = openedBy;
        this.closeBy = closeBy;
        this.messages = messages;
    }

    public UUID getId() {
        return id;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Date getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public UUID getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(UUID openedBy) {
        this.openedBy = openedBy;
    }

    public UUID getCloseBy() {
        return closeBy;
    }

    public void setCloseBy(UUID closeBy) {
        this.closeBy = closeBy;
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void setMessages(LinkedList<Message> messages) {
        this.messages = messages;
    }
}
