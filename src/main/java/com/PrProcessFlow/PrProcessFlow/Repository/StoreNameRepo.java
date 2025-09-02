package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.StoreName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreNameRepo extends JpaRepository<StoreName, Integer> {
    public StoreName findById(int id);
    public StoreName findByStoreName(String storeName);


}
