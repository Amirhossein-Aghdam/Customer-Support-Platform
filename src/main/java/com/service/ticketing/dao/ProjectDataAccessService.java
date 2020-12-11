package com.service.ticketing.dao;


import com.service.ticketing.models.projects.Project;
import com.service.ticketing.models.projects.roles.*;
import com.service.ticketing.models.projects.systems.SubSystem;
import com.service.ticketing.models.projects.tickets.Ticket;
import com.service.ticketing.models.response.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

@Qualifier("LinkedDao")
@Repository
public class ProjectDataAccessService implements ProjectDao {

    @Value("${project.path}")
    private String filePath;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

   public Boolean checkFileExistence() {
       File dataFile = new File(filePath);
       return dataFile.exists();
   }

   public Boolean isFileEmpty(){
       File dataFile = new File(filePath);
       return dataFile.length() == 0;
   }

    @Override
    public void saveData(Project projects) throws IOException {
            if(checkFileExistence()) {
                FileOutputStream fileOut = new FileOutputStream(filePath);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(projects);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in /tmp/projects.ser");
            }
            else{
                File newFile = new File(filePath);
                newFile.createNewFile();
                saveData(projects);
            }
    }

    @Override
    public Project fetchData() throws IOException, ClassNotFoundException {
        if(checkFileExistence()) {
            if(!isFileEmpty()) {
                FileInputStream fileIn = new FileInputStream(filePath);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Project projects = (Project) in.readObject();
                in.close();
                fileIn.close();
                return projects;
            }
            else{
                Project projects = new Project(new LinkedList<>(), new LinkedList<>(), new LinkedList<>(),
                        new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
                saveData(projects);
                return projects;
            }
        }

        else if(!checkFileExistence()){
            File newFile = new File(filePath);
            newFile.createNewFile();
            return fetchData();
        }
        return null;
    }

    @Override
    public LinkedList<Analyzer> getAnalyzers() throws IOException, ClassNotFoundException {
        return (LinkedList<Analyzer>)fetchData().getAnalyzers();
    }

    @Override
    public LinkedList<Customer> getCustomers() throws IOException, ClassNotFoundException {
        return (LinkedList<Customer>) fetchData().getCustomers();
    }

    @Override
    public LinkedList<Designer> getDesigners() throws IOException, ClassNotFoundException {
        return (LinkedList<Designer>)fetchData().getDesigners();
    }

    @Override
    public LinkedList<Programmer> getProgrammers() throws IOException, ClassNotFoundException{
        return (LinkedList<Programmer>)fetchData().getProgrammers();
    }

    @Override
    public LinkedList<Manager> getManager() throws IOException, ClassNotFoundException {
        return (LinkedList<Manager>)fetchData().getManagers();
    }

    @Override
    public User loadUserByUsername(String username) throws IOException, ClassNotFoundException {
        Project projects = fetchData();
        LinkedList<Customer> customers = projects.getCustomers();
        LinkedList<Designer> designers = projects.getDesigners();
        LinkedList<Programmer> programmers = projects.getProgrammers();
        LinkedList<Analyzer> analyzers = projects.getAnalyzers();
        LinkedList<Manager> managers = projects.getManagers();

        //check customers list
        for(int i=0; i<customers.size(); i++){
            if(customers.get(i).getUsername().equals(username)) {
                Collection<GrantedAuthority> roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority(Constants.CUSTOMER));
                return new User(customers.get(i).getUsername(), customers.get(i).getPass(),roles,
                        customers.get(i).getId(), customers.get(i).getSystem());
            }
        }

        //check designers list
        for(int i=0; i<designers.size(); i++){
            if(designers.get(i).getUsername().equals(username)) {
                Collection<GrantedAuthority> roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority(Constants.DESIGNER));
                return new User(designers.get(i).getUsername(), designers.get(i).getPass(),roles,
                        designers.get(i).getId(), designers.get(i).getSystem());
            }
        }

        //check programmers list
        for(int i=0; i<programmers.size(); i++){
            if(programmers.get(i).getUsername().equals(username)) {
                Collection<GrantedAuthority> roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority(Constants.PROGRAMMER));
                return new User(programmers.get(i).getUsername(), programmers.get(i).getPass(),roles,
                        programmers.get(i).getId(), programmers.get(i).getSystem());
            }
        }

        //check analyzers list
        for(int i=0; i<analyzers.size(); i++){
            if(analyzers.get(i).getUsername().equals(username)) {
                Collection<GrantedAuthority> roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority(Constants.ANALYSER));
                return new User(analyzers.get(i).getUsername(), analyzers.get(i).getPass(),roles,
                        analyzers.get(i).getId(), analyzers.get(i).getSystem());
            }
        }

        //maybe it's the boss knocking the door :D
        for(int i=0; i<managers.size(); i++){
            if(managers.get(i).getUsername().equals(username)) {
                Collection<GrantedAuthority> roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority(Constants.MANAGER));
                return new User(managers.get(i).getUsername(), managers.get(i).getPass(),roles,
                        managers.get(i).getId(), managers.get(i).getSystem() );
            }
        }

        if(username.equals(adminUsername)){
            Collection<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(Constants.ADMIN));
            return new User(adminUsername, adminPassword, roles
                    , UUID.fromString("318758ee-c4d1-4974-af2e-d763cc480a3b")
                    ,UUID.fromString("d3cdfdf5-9d90-4559-a040-ba77fe1f10c3"));
        }

        //that's ok if there's no such a user, tell him!
        return null;
    }

    @Override
    public String loadRoleByUsername(String username) throws IOException, ClassNotFoundException {
        User user = loadUserByUsername(username);
        return user.getRoles().toArray()[0].toString();
    }

    @Override
    public Customer addCustomer(Customer customer) throws IOException, ClassNotFoundException {
        Project project = fetchData();
        LinkedList<Customer> customers = project.getCustomers();
        Customer newCustomer =
                new Customer(customer.getName(),customer.getUsername(), customer.getPass(),
                        customer.getTitle(), customer.getSystem());
        customers.add(newCustomer);
        project.setCustomers(customers);
        saveData(project);
        return newCustomer;
    }

    @Override
    public Manager addManager(Manager manager) throws IOException, ClassNotFoundException {
        Project project = fetchData();
        LinkedList<Manager> managers = project.getManagers();
        Manager newManager =
                new Manager(manager.getName(), manager.getUsername(), manager.getPass(),
                        manager.getTitle(), manager.getSystem());
        managers.add(newManager);
        project.setManagers(managers);
        saveData(project);
        return newManager;
    }

    @Override
    public Designer addDesigner(Designer designer) throws IOException, ClassNotFoundException {
        Project project = fetchData();
        LinkedList<Designer> designers = project.getDesigners();
        Designer newDesigner = new Designer(designer.getName(),designer.getUsername(),
                designer.getPass(), designer.getSystem(),designer.getTitle());
        designers.add(newDesigner);
        project.setDesigners(designers);
        saveData(project);
        return newDesigner;
    }

    @Override
    public Programmer addProgrammer(Programmer programmer) throws IOException, ClassNotFoundException {
        Project project = fetchData();
        LinkedList<Programmer> programmers = project.getProgrammers();
        Programmer newProgrammer = new Programmer(programmer.getName(),programmer.getUsername(),
                programmer.getPass(),programmer.getSystem() ,programmer.getTitle());
        programmers.add(newProgrammer);
        project.setProgrammers(programmers);
        saveData(project);
        return newProgrammer;
    }

    @Override
    public Analyzer addAnalyzer(Analyzer analyzer) throws IOException, ClassNotFoundException {
        Project project = fetchData();
        LinkedList<Analyzer> analyzers = project.getAnalyzers();
        Analyzer newAnalyzer = new Analyzer(analyzer.getName(), analyzer.getUsername(),
                analyzer.getPass(), analyzer.getTitle(), analyzer.getSystem());
        analyzers.add(newAnalyzer);
        project.setAnalyzers(analyzers);
        saveData(project);
        return newAnalyzer;
    }

    @Override
    public UUID loadSystemByUsername(String username) throws IOException, ClassNotFoundException {
        return loadUserByUsername(username).getSystem();
    }

    @Override
    public SubSystem addSubSystem(SubSystem subSystem) throws IOException, ClassNotFoundException {
        Project project = fetchData();
        SubSystem newSubSystem = new SubSystem(subSystem.getName(),subSystem.getCompleted());
        LinkedList<SubSystem> subSystems = project.getSubSystems();
        subSystems.add(newSubSystem);
        project.setSubSystems(subSystems);
        return newSubSystem;
    }

    @Override
    public Ticket createTicketAsCustomer(Ticket ticket, String username) throws IOException, ClassNotFoundException {
       User user = loadUserByUsername(username);
       Ticket newTicket = new Ticket(ticket.getIssueTitle());
        newTicket.setSystem(user.getSystem());
        newTicket.setOpenedBy(user.getId());
        Project project = fetchData();
        LinkedList<Customer> customers = project.getCustomers();
        for(Customer customer: customers){
            if(customer.getUsername().equals(username)){
                LinkedList<Ticket> issues = customer.getIssues();
                issues.add(newTicket);
                customer.setIssues(issues);
            }
        }
        project.setCustomers(customers);
        saveData(project);
        return newTicket;
    }
}
