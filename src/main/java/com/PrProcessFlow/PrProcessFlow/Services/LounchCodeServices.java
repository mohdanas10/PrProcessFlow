package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.LounchCode;
import com.PrProcessFlow.PrProcessFlow.Repository.LounchCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LounchCodeServices {

    @Autowired
    private LounchCodeRepo lounchCodeRepo;

    public String addLounchCode(LounchCode lounchCode){
        LounchCode saved = this.lounchCodeRepo.save(lounchCode);
        if(saved!=null && saved.getId() > 0){
            return "Lounch Code Added Successfully";
        }
        else {
            return "Failed to save Lounch Code";
        }

    }

}
