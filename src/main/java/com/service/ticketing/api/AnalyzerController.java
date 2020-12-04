package com.service.ticketing.api;

import com.service.ticketing.models.projects.roles.Analyzer;
import com.service.ticketing.models.projects.roles.Constants;
import com.service.ticketing.services.AnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("api/analyzer")
@RestController
public class AnalyzerController {

    private final AnalyzerService analyzerService;

    @Autowired
    public AnalyzerController(AnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }

    @PostMapping("create")
    @PreAuthorize(Constants.ADMIN_has + " or " + Constants.MANAGER_has)
    public Analyzer createAnalyzer(@RequestBody Analyzer analyzer) throws IOException, ClassNotFoundException {
        return analyzerService.addAnalyzer(analyzer);
    }
}
