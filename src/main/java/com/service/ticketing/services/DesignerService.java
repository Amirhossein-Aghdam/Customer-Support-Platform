package com.service.ticketing.services;

import com.service.ticketing.dao.ProjectDao;
import com.service.ticketing.models.projects.roles.Designer;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DesignerService {

    private final ProjectDao projectDao;

    public DesignerService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Designer addDesigner(Designer designer) throws IOException, ClassNotFoundException {
        return projectDao.addDesigner(designer);
    }
}
