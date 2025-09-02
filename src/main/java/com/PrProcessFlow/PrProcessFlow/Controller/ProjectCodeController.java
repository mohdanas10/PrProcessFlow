package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.ProjectCode;
import com.PrProcessFlow.PrProcessFlow.Services.ProjectCodeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*")
public class ProjectCodeController {

    @Autowired
    private ProjectCodeServices projectCodeServices;

    @PostMapping("/add-project-code")
    public String addProjectCode(@RequestBody ProjectCode projectCode) {
        return  this.projectCodeServices.addProjectCode(projectCode);
    }
}
