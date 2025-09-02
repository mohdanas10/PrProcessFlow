package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.Vendor;
import com.PrProcessFlow.PrProcessFlow.Services.VendorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class VendorController {

    @Autowired
    private VendorServices vendorServices;

    @PostMapping("/add-vendor")
    public String addVendor(@RequestBody List<Vendor> vendorList){
        return this.vendorServices.addVendor(vendorList);
    }

    @GetMapping("/get-vendors")
    public List<Vendor> getVendors(){
        return this.vendorServices.getVendors();
    }


    @GetMapping("/get-secret-key")
    public String getSecretKey(){
        return "Anas@Zeptonow@580";
    }
}
