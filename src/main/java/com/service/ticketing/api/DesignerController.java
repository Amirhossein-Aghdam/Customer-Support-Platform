package com.service.ticketing.api;

import com.service.ticketing.models.projects.roles.Constants;
import com.service.ticketing.models.projects.roles.Designer;
import com.service.ticketing.services.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("api/designer")
@RestController
public class DesignerController {

    private final DesignerService designerService;

    @Autowired
    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }

    @PostMapping("create")
    @PreAuthorize(Constants.ADMIN_has + " or " + Constants.MANAGER_has)
    public Designer createDesigner(@RequestBody Designer designer) throws IOException, ClassNotFoundException {
        return designerService.addDesigner(designer);
    }
}
