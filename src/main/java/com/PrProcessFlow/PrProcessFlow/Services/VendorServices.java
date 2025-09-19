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
            Vendor existsByVendorName = this.vendorRepo.findByVendorName(vendor.getVendorName());
            Vendor existsByVendorCode = this.vendorRepo.findByVendorCode(vendor.getVendorCode());
            if(existsByVendorName == null && existsByVendorCode == null){
                this.vendorRepo.save(vendor);
            }
        }
        return "Vendor successfully added";
    }

    public List<Vendor> getVendors(){
        return this.vendorRepo.findAll();
    }

    public String addSingleVendor(Vendor vendor){

        Vendor isExist = this.vendorRepo.findByVendorCode(vendor.getVendorCode());
        if(isExist == null){
            this.vendorRepo.save(vendor);
            return "Vendor Added Successfully";
        }
        return "Vendor Not Added !!!";
    }

    public String updateVendor(Vendor vendor){
        Vendor v = this.vendorRepo.findById(vendor.getId());
        if(v != null){
            v.setVendorCode(vendor.getVendorCode());
            v.setVendorName(vendor.getVendorName());
            v.setVendorCategory(vendor.getVendorCategory());
            return "Vendor Updated Successfully";
        }
        return "Error !!!";
    }

    public String deleteVendor(int id ){
        Vendor v = this.vendorRepo.findById(id);
        this.vendorRepo.delete(v);
        return "Vendor Deleted Successfully";
    }

}
