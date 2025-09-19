package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository<Vendor,Integer> {
    public Vendor id(int id);
    public Vendor findByVendorName(String name);
    public Vendor findByVendorCode(String code);
    public Vendor findById(int id);
}
