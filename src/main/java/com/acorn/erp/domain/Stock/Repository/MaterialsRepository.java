package com.acorn.erp.domain.Stock.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Stock.Entity.Materials;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, Long> {
	List<Materials> findByItemCodeContainingIgnoreCaseOrItemNameContainingIgnoreCase(String itemCode, String itemName);	
	
}


