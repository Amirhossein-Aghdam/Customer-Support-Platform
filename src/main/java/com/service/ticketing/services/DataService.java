package com.service.ticketing.services;

import com.service.ticketing.dao.ProjectDao;
import com.service.ticketing.models.projects.Project;
import com.service.ticketing.models.response.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DataService {

    @Autowired
    private final ProjectDao projectDao;

    @Autowired
    public DataService(@Qualifier("LinkedDao") ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void saveData(Project projects) throws IOException {
        projectDao.saveData(projects);
    }

    public Project fetchData() throws IOException, ClassNotFoundException {
        return projectDao.fetchData();
    }

    public User loadUserByUsername(String username) throws IOException, ClassNotFoundException {
        return projectDao.loadUserByUsername(username);
    }

    public String loadRoleByUsername(String username) throws IOException, ClassNotFoundException {
        return projectDao.loadRoleByUsername(username);
    }
}
