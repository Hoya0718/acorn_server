package com.acorn.erp.domain.Sales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Sales.Entity.InventoryTable;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryTable, Long> {
	InventoryTable findByItemCode(Long itemCode);
}
