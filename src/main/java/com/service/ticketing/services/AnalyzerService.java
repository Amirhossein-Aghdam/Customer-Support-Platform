package com.service.ticketing.services;

import com.service.ticketing.dao.ProjectDao;
import com.service.ticketing.models.projects.roles.Analyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AnalyzerService {

    private final ProjectDao projectDao;

    @Autowired
    public AnalyzerService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Analyzer addAnalyzer(Analyzer analyzer) throws IOException, ClassNotFoundException {
        return projectDao.addAnalyzer(analyzer);
    }
}
