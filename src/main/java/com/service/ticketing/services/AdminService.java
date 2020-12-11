package com.service.ticketing.services;

import com.service.ticketing.dao.ProjectDao;
import com.service.ticketing.models.projects.systems.SubSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AdminService {


    private final ProjectDao projectDao;

    @Autowired
    public AdminService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public SubSystem addSubSystem(SubSystem subSystem) throws IOException, ClassNotFoundException {
        return projectDao.addSubSystem(subSystem);
    }
}
