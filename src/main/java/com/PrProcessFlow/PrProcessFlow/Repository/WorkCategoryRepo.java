package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.WorkCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkCategoryRepo extends JpaRepository<WorkCategory, Integer> {
    public List<WorkCategory> findByCategoryName(String name);
    public WorkCategory findById(int id);
    public WorkCategory findByCategoryType(String categoryType);
}
