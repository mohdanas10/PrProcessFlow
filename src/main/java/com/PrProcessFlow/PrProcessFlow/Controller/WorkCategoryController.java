package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.WorkCategory;
import com.PrProcessFlow.PrProcessFlow.Services.WorkCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class WorkCategoryController {

    @Autowired
    private WorkCategoryServices workCategoryServices;

    @PostMapping("/add-work-category")
    public String addWorkCategory(@RequestBody List<WorkCategory> workCategory){
        for(WorkCategory wc : workCategory){
            System.out.println(wc.getCategoryName());
            System.out.println(wc.getCategoryType());
        }
        return this.workCategoryServices.addWorkCategory(workCategory);
    }

    @GetMapping("/get-work-categories")
    public List<WorkCategory> getWorkCategories(){
        return this.workCategoryServices.getWorkCategories();
    }
}
