package com.PrProcessFlow.PrProcessFlow.Services;


import com.PrProcessFlow.PrProcessFlow.Entity.StoreId;
import com.PrProcessFlow.PrProcessFlow.Repository.StoreIdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@Component
public class StoreIdServices {

    @Autowired
    private StoreIdRepo storeIdRepo;

    public String addStoreId(StoreId storeId) {
        if (storeIdRepo.findByStoreId(storeId.getStoreId()) == null) {
            this.storeIdRepo.save(storeId);
            return "StoreId Added Successfully";
        }
        return "StoreId Already Exists";

    }

    public List<StoreId> getAllStoreIds() {
        return this.storeIdRepo.findAll();
    }
}
