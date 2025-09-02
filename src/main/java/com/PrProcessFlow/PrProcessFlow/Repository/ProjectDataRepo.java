package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.ProjectData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDataRepo extends JpaRepository<ProjectData, Integer> {
    public ProjectData findById(int id);
//    public ProjectData findByLounchCode(String lounchCode);
//    public ProjectData findByProjectCode(String projectCode);

}
