package com.service.ticketing.models.projects.roles;

//Main admin model class
public class Admin{

    private String name;
    private String username;
    private String pass;
    private String role;

    public Admin(String name) {
        this.name = name;
        this.username = "admin";
        this.pass = "admin" ;
        this.role= Constants.ADMIN;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }
}
