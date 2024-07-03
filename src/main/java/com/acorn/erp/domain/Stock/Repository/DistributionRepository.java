package com.acorn.erp.domain.Stock.Repository;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Stock.Entity.Distribution;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Long> {
	List<Distribution> findByDistributionCodeContainingIgnoreCaseOrDistributionNameContainingIgnoreCase(String DistributionCode, String DistributioName);	
	
}
