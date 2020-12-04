package com.service.ticketing.services;

import com.service.ticketing.dao.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private final ProjectDao projectDao;

    public AdminService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }


}
