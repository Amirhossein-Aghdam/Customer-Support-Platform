package com.service.ticketing.api;

import com.service.ticketing.dao.ProjectDao;
import com.service.ticketing.models.projects.Project;
import com.service.ticketing.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("api")
@RestController
public class AdminController {

    private final DataService dataService;

    @Autowired
    public AdminController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("createProject")
    public Project createProject(@RequestBody Project project) throws IOException {
        dataService.saveData(project);
        return project;
    }


}
