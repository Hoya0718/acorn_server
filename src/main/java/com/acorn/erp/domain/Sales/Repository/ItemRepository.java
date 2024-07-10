package com.acorn.erp.domain.Sales.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Sales.Entity.ItemTable;

@Repository
public interface ItemRepository extends JpaRepository<ItemTable, Long> {
    Optional<ItemTable> findByItemCode(Long itemCode);
    boolean existsByItemName(String itemName);
}