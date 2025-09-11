package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.Department;
import com.PrProcessFlow.PrProcessFlow.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/add-department")
    public String addDepartment(@RequestBody List<Department> departments){
        return this.departmentServices.addDepartment(departments);
    }

    @GetMapping("/get-departments")
    public List<Department> getAllDepartment(){
        return this.departmentServices.getAllDepartment();
    }
}
