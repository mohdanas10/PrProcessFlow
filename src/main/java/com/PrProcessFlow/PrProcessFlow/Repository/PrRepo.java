package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.Pr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PrRepo extends JpaRepository<Pr, Integer> {
    public Pr findById(int id);
    Page<Pr> findByPrStatusOrderByIdDesc(String prStatus, Pageable pageable);
    @Query("SELECT COUNT(p) FROM Pr p " +
            "WHERE FUNCTION('MONTH', p.createdDate) = FUNCTION('MONTH', CURRENT_DATE) " +
            "AND FUNCTION('YEAR', p.createdDate) = FUNCTION('YEAR', CURRENT_DATE)")
    long countCurrentMonthEntries();
    List<Pr> findAllByOrderByIdDesc();
    List<Pr>findAllByPrStatusOrderByIdDesc(String prStatus);

}
