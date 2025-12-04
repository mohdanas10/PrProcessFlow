package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.CostCenter;
import com.PrProcessFlow.PrProcessFlow.Entity.Pr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostCenterRepo extends JpaRepository<CostCenter, Integer> {
    public CostCenter findByProjectCode(String projectCode);
    public CostCenter findByStoreCode(String storeCode);
    public CostCenter findById(int id);
    List<CostCenter> findAllByOrderByIdDesc();
    List<CostCenter> findTop5ByOrderByIdDesc();
}
