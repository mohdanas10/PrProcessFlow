package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.Vendor;
import com.PrProcessFlow.PrProcessFlow.Repository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Component
public class VendorServices {

    @Autowired
    private VendorRepo  vendorRepo;

    public String addVendor(List<Vendor> vendorList){
        for (Vendor vendor : vendorList) {
            Vendor existsByVendorName = (Vendor) this.vendorRepo.findByVendorName(vendor.getVendorName());
            Vendor existsByVendorCode = (Vendor) this.vendorRepo.findByVendorCode(vendor.getVendorCode());
            if(existsByVendorName == null && existsByVendorCode == null){
                this.vendorRepo.save(vendor);
            }
        }
        return "Vendor successfully added";
    }

    public List<Vendor> getVendors(){
        return this.vendorRepo.findAll();
    }

}
