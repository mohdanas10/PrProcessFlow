package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.CostCenter;
import com.PrProcessFlow.PrProcessFlow.Repository.CostCenterRepo;
import com.PrProcessFlow.PrProcessFlow.Services.CostCenterServices;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class CostCenterController {

    @Autowired
    private CostCenterServices costCenterServices;


    @PostMapping("/add-cost-center")
    public String addCostCenter(@RequestBody CostCenter costCenter){
        return this.costCenterServices.addCostCenter(costCenter);
    }

    @PostMapping("/add-bulk-cost-center")
    public String addBulkCostCenter(@RequestBody List<CostCenter> costCenters){
        return this.costCenterServices.addBulkCostCenter(costCenters);
    }

    @GetMapping("/get-all-cost-center")
    public List<CostCenter> getAllCostCenter(){
        return this.costCenterServices.getAllCostCenter();
    }

    @DeleteMapping("/delete-cost-center/{id}")
    public String deleteCostCenterById(@PathVariable int id){
        return this.costCenterServices.deleteCostCenterById(id);
    }

    @PutMapping("/update-cost-center/{id}")
    public String updateCostCenter(@PathVariable int id, @RequestBody CostCenter costCenter){
        return this.costCenterServices.updateCostCenter(id, costCenter);
    }
}
