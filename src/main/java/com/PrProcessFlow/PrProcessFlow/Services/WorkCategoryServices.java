package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.WorkCategory;
import com.PrProcessFlow.PrProcessFlow.Repository.WorkCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkCategoryServices {

    @Autowired
    private WorkCategoryRepo workCategoryRepo;

    public String addWorkCategory(List<WorkCategory> workCategory){

       for(WorkCategory wc : workCategory){
           List<WorkCategory> allCategories = this.workCategoryRepo.findAll();
           WorkCategory isExists = this.workCategoryRepo.findByCategoryName(wc.getCategoryName());
           WorkCategory isCategoryTypeExists = this.workCategoryRepo.findByCategoryType(wc.getCategoryType());
           if(isExists == null && isCategoryTypeExists == null){
               this.workCategoryRepo.save(wc);
           }
           else if(isExists != null && isCategoryTypeExists == null){
               this.workCategoryRepo.save(wc);
           }
           else if(isExists == null && isCategoryTypeExists != null){
               this.workCategoryRepo.save(wc);
           }



       }

       return "WorkCategory Added Successfully";

    }

    public List<WorkCategory> getWorkCategories(){
        return this.workCategoryRepo.findAll();
    }
}
