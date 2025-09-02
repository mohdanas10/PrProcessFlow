package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository<Vendor,Integer> {
    public VendorRepo id(int id);
    public VendorRepo findByVendorName(String name);
    public VendorRepo findByVendorCode(String code);
}
