package com.service.ticketing.services;

import com.service.ticketing.dao.ProjectDao;
import com.service.ticketing.models.projects.roles.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ManagerService {

    private final ProjectDao projectDao;

    @Autowired
    public ManagerService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Manager addManger(Manager manager) throws IOException, ClassNotFoundException {
        return projectDao.addManager(manager);
    }
}
