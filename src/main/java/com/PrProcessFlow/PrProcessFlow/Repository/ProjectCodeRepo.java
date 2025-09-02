package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.ProjectCode;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectCodeRepo extends JpaRepository<ProjectCode, Integer> {
    public ProjectCode findById(int id);
}
