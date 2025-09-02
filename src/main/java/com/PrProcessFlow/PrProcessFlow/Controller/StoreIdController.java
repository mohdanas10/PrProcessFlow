package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.StoreId;
import com.PrProcessFlow.PrProcessFlow.Services.StoreIdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class StoreIdController {

    @Autowired
    private StoreIdServices storeIdServices;

    @PostMapping("/add-storeid")
    public String addStoreId(@RequestBody StoreId storeId) {
        return  this.storeIdServices.addStoreId(storeId);
    }

    @GetMapping("/get-store-ids")
    public List<StoreId> getAllStoreIds() {
        return this.storeIdServices.getAllStoreIds();
    }
}
