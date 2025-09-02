package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.ProjectData;
import com.PrProcessFlow.PrProcessFlow.Services.ProjectDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class ProjectDataController {
    @Autowired
    private ProjectDataServices projectDataServices;

    @PostMapping("/add-project-data")
    public String addProjectData(@RequestBody ProjectData projectData) {
        return this.projectDataServices.addProjectData(projectData);
    }

    @GetMapping("/get-project-data")
    public List<ProjectData> getProjectData() {
        return this.projectDataServices.allProjectData();
    }
}
