package com.acorn.erp.domain.Sales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acorn.erp.domain.Sales.Entity.InventoryTable;

public interface InventoryRepository extends JpaRepository<InventoryTable, Long> {
	InventoryTable findByItemCode(Long itemCode);
}
