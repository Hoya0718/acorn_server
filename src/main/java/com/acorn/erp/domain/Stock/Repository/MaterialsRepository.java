package com.acorn.erp.domain.Stock.Repository;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Stock.Entity.Distribution;
import com.acorn.erp.domain.Stock.Entity.Materials;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, Long> {
	List<Materials> findByMaterialsCodeContainingIgnoreCaseOrMaterialsNameContainingIgnoreCase(String MaterialsCode, String MaterialsName);	
	
}
