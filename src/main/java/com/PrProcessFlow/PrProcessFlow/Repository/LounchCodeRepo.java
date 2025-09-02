package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.LounchCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LounchCodeRepo extends JpaRepository<LounchCode, Integer> {

    public LounchCode findById(int id);

}
