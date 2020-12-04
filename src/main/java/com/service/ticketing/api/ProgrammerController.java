package com.service.ticketing.api;

import com.service.ticketing.models.projects.roles.Constants;
import com.service.ticketing.models.projects.roles.Programmer;
import com.service.ticketing.services.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("api/programmer")
@RestController
public class ProgrammerController {

    private final ProgrammerService programmerService;

    @Autowired
    public ProgrammerController(ProgrammerService programmerService) {
        this.programmerService = programmerService;
    }

    @PostMapping("create")
    @PreAuthorize(Constants.ADMIN_has + " or " + Constants.MANAGER_has)
    public Programmer createProgrammer(@RequestBody Programmer programmer) throws IOException, ClassNotFoundException {
        return programmerService.addProgrammer(programmer);
    }
}
