package com.acorn.erp.domain.Stock.Repository;

import com.acorn.erp.domain.Stock.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
