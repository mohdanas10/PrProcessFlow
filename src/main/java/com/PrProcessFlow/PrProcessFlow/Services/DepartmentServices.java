package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.Department;
import com.PrProcessFlow.PrProcessFlow.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices {
    @Autowired
    private DepartmentRepo departmentRepo;

    public String addDepartment(List<Department> departments){
        for(Department dc : departments){
            if(this.departmentRepo.findBydepartment(dc.getDepartment()) == null){
                this.departmentRepo.save(dc);
            }
        }
        return "Department Added Successfully";
    }

    public List<Department> getAllDepartment (){
        return this.departmentRepo.findAll();
    }
}
