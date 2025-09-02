package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.StoreName;
import com.PrProcessFlow.PrProcessFlow.Repository.StoreNameRepo;
import com.PrProcessFlow.PrProcessFlow.Services.StoreNameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class StoreNameController {

    @Autowired
    private StoreNameServices storeNameServices;

    @PostMapping("/add-store-name")
    public String addStoreName(@RequestBody StoreName storeName) {
        return  this.storeNameServices.addStoreName(storeName);
    }

    @GetMapping("/get-store-names")
    public List<StoreName> getStoreNames() {
        return this.storeNameServices.getStoreNames();
    }
}
