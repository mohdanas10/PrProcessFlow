package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.ProjectData;
import com.PrProcessFlow.PrProcessFlow.Repository.ProjectDataRepo;
import org.hibernate.annotations.ConcreteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectDataServices {

    @Autowired
    private ProjectDataRepo projectDataRepo;

    public String addProjectData(ProjectData projectData) {
        ProjectData saved = this.projectDataRepo.save(projectData);
        if (saved != null && saved.getId() > 0) {
            return "Project Data Added Successfully";
        }
        else{
            return "Project Data Not Saved";
        }
    }

    public List<ProjectData> allProjectData() {
        return this.projectDataRepo.findAll();
    }
}
