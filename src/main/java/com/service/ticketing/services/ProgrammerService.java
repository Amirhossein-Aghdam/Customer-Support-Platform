package com.service.ticketing.services;

import com.service.ticketing.dao.ProjectDao;
import com.service.ticketing.models.projects.roles.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProgrammerService {

    private final ProjectDao projectDao;

    @Autowired
    public ProgrammerService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Programmer addProgrammer(Programmer programmer) throws IOException, ClassNotFoundException {
        return projectDao.addProgrammer(programmer);
    }
}
