package com.service.ticketing.api;

import com.service.ticketing.models.projects.roles.Constants;
import com.service.ticketing.models.projects.roles.Manager;
import com.service.ticketing.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("api/manager")
@RestController
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("create")
    @PreAuthorize(Constants.ADMIN_has + " or " + Constants.MANAGER_has)
    public Manager createManager(@RequestBody Manager manager) throws IOException, ClassNotFoundException {
        return managerService.addManger(manager);
    }
}
