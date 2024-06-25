package com.acorn.erp.domain.Customer.Repository;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acorn.erp.domain.Customer.Entity.CustomerInfo;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer>{
	@Query("SELECT COUNT(c) FROM CustomerInfo c WHERE c.registerDate <= :endDate")
    long countCustomersLastyear(@Param("endDate") Date endDate);
}
