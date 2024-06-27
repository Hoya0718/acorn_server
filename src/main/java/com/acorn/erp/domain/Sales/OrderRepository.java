package com.acorn.erp.domain.Sales;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;

public interface OrderRepository extends JpaRepository<OrderTable, Integer>{
	// customerId를 기준으로 존재 여부 확인
    boolean existsByCustomerId(int customerId);
    
    List<OrderTable> findByCustomerId(int customerId);
}
