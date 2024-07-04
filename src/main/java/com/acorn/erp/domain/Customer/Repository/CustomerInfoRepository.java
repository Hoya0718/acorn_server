package com.acorn.erp.domain.Customer.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer>{
	@Query("SELECT COUNT(c) FROM CustomerInfo c WHERE c.registerDate <= :endDate")
    long countCustomersLastyear(@Param("endDate") Date endDate);
    
	List<CustomerInfo> findByCustomerId(int customerId);
}
