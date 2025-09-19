package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.CostCenter;
import com.PrProcessFlow.PrProcessFlow.Repository.CostCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostCenterServices {

    @Autowired
    private CostCenterRepo costCenterRepo;

    public String addCostCenter(CostCenter costCenter){
        CostCenter isExist = this.costCenterRepo.findByProjectCode(costCenter.getProjectCode());
        if(isExist == null){
            this.costCenterRepo.save(costCenter);
            return "CostCenter Added Successfully";
        }
        return "CostCenter Already Exist";
    }

    public String addBulkCostCenter(List<CostCenter> costCenters){
        for(CostCenter cs : costCenters){
            CostCenter isExistByProjectCode = this.costCenterRepo.findByProjectCode(cs.getProjectCode());
            if(isExistByProjectCode == null){
                this.costCenterRepo.save(cs);
            }
        }

        return "Cost Center Added Successfully";
    }

    public List<CostCenter> getAllCostCenter (){
        return this.costCenterRepo.findAllByOrderByIdDesc();
    }

    public String deleteCostCenterById(int id){
        this.costCenterRepo.findById(id);
        return "cost Center Deleted Successfully";
    }

    public String updateCostCenter(int id, CostCenter costCenter){
        CostCenter cs = this.costCenterRepo.findById(id);
        if(cs != null){
            cs.setAddress(costCenter.getAddress());
            cs.setCity(costCenter.getCity());
            cs.setState(costCenter.getState());
            cs.setRegion(costCenter.getRegion());
            cs.setPinCode(costCenter.getPinCode());
            cs.setStoreType(costCenter.getStoreType());
            cs.setStoreName(costCenter.getStoreName());
            cs.setProjectCode(costCenter.getProjectCode());
            cs.setStoreCode(costCenter.getStoreCode());
            this.costCenterRepo.save(cs);
            return "cost Center Updated Successfully";
        }
        return "Error to update cost Center !!";
    }
}
