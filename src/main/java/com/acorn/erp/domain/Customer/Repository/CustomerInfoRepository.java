package com.acorn.erp.domain.Customer.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer>{
	
	@Query("SELECT COUNT(c) FROM CustomerInfo c WHERE c.registerDate <= :endDate")
    long countCustomersLastyear(@Param("endDate") Date endDate);
    
	List<CustomerInfo> findByCustomerId(int customerId);
	
	@Query("SELECT u FROM CustomerInfo u WHERE u.customerName LIKE %:keyword% OR u.customerAddr LIKE %:keyword%")
	List<CustomerInfo> searchCustomerInfoByKeyword(@Param("keyword") String keyword);
}
