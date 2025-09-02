package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.StoreType;
import com.PrProcessFlow.PrProcessFlow.Services.StoreTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class StoreTypeController {

    @Autowired
    private StoreTypeServices storeTypeServices;

    @GetMapping("/get-store-types")
    public List<StoreType> getStoreTypes() {    
        return this.storeTypeServices.getStoreTypes();
    }

    @PostMapping("/add-store-types")
    public String addStoreType(@RequestBody StoreType storeType) {
        return this.storeTypeServices.addStoreTypes(storeType);
    }
}
