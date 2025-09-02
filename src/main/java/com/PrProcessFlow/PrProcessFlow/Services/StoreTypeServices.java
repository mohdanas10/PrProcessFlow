package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.StoreType;
import com.PrProcessFlow.PrProcessFlow.Repository.StoreTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreTypeServices {

    @Autowired
    private StoreTypeRepo storeTypeRepo;

    public List<StoreType> getStoreTypes() {
        return this.storeTypeRepo.findAll();
    }

    public String addStoreTypes(StoreType storeType) {
        if(storeTypeRepo.findByTypeName(storeType.getTypeName()) == null) {
            this.storeTypeRepo.save(storeType);
            return "Store Type Added Successfully";
        }
        return "Store Type Already Exists";

    }


}
