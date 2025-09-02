package com.PrProcessFlow.PrProcessFlow.Services;


import com.PrProcessFlow.PrProcessFlow.Entity.StoreName;
import com.PrProcessFlow.PrProcessFlow.Repository.StoreNameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreNameServices {

    @Autowired
    private StoreNameRepo storeNameRepo;

    public String addStoreName(StoreName storeName) {
        if (storeNameRepo.findByStoreName(storeName.getStoreName()) == null) {
            this.storeNameRepo.save(storeName);
            return "StoreName Added Successfully";
        }
        return "StoreName Already Exists";

    }

    public List<StoreName> getStoreNames() {
        return this.storeNameRepo.findAll();
    }
}
