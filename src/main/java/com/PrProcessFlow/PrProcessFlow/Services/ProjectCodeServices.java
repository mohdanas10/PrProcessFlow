package com.PrProcessFlow.PrProcessFlow.Services;


import com.PrProcessFlow.PrProcessFlow.Entity.ProjectCode;
import com.PrProcessFlow.PrProcessFlow.Repository.ProjectCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectCodeServices {

    @Autowired
    private ProjectCodeRepo projectCodeRepo;

    public String addProjectCode(ProjectCode projectCode) {
        this.projectCodeRepo.save(projectCode);
        return "Project Code Added Successfully";
    }

}
