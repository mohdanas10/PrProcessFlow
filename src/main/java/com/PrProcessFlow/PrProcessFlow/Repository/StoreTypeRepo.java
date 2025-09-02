package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.StoreType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreTypeRepo extends JpaRepository<StoreType, Integer> {
    public StoreType findById(int id);
    public StoreType findByTypeName(String typeName);

}
