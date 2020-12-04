package com.service.ticketing.dao;

import com.service.ticketing.models.projects.Project;
import com.service.ticketing.models.projects.roles.*;
import com.service.ticketing.models.response.User;

import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;


public interface ProjectDao {

    //save data into temp serialized file
    void saveData(Project projects) throws IOException;

    //fetch data from temp serialized file
    Project fetchData() throws IOException, ClassNotFoundException;

    //get every role involved in projects as a list
    LinkedList<Analyzer> getAnalyzers() throws IOException, ClassNotFoundException;
    LinkedList<Customer> getCustomers() throws IOException, ClassNotFoundException;
    LinkedList<Designer> getDesigners() throws IOException, ClassNotFoundException;
    LinkedList<Programmer> getProgrammers() throws IOException, ClassNotFoundException;
    LinkedList<Manager> getManager() throws IOException, ClassNotFoundException;

    //finds an specific user by username
    User loadUserByUsername(String username) throws IOException, ClassNotFoundException;

    //finds the role of a user
    String loadRoleByUsername(String username) throws IOException, ClassNotFoundException;

    //create users
    Customer addCustomer(Customer customer) throws IOException, ClassNotFoundException;
    Manager addManager(Manager manager) throws IOException, ClassNotFoundException;
    Designer addDesigner(Designer designer) throws IOException, ClassNotFoundException;
    Programmer addProgrammer(Programmer programmer) throws IOException, ClassNotFoundException;
    Analyzer addAnalyzer(Analyzer analyzer) throws IOException, ClassNotFoundException;

    //Manager eligibility check to create Roles
    UUID loadSystemByUsername(String username) throws IOException, ClassNotFoundException;
}
