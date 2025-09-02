package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.StoreId;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface StoreIdRepo extends JpaRepository<StoreId, Integer> {

    public StoreId findById(int id);
    public StoreId findByStoreId(String storeId);

}
