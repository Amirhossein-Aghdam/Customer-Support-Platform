package com.service.ticketing.models.projects.tickets;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

//message model class in a ticket
public class Message implements Serializable {
    String text;
    LinkedList<String> attachedLinks;
    Date time;
    Boolean fromMe;

    public Message() {
    }

    public Message(String text, LinkedList<String> attachedLinks, Date time, Boolean fromMe) {
        this.text = text;
        this.attachedLinks = attachedLinks;
        this.time = time;
        this.fromMe = fromMe;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LinkedList<String> getAttachedLinks() {
        return attachedLinks;
    }

    public void setAttachedLinks(LinkedList<String> attachedLinks) {
        this.attachedLinks = attachedLinks;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean getFromMe() {
        return fromMe;
    }

    public void setFromMe(Boolean fromMe) {
        this.fromMe = fromMe;
    }
}
