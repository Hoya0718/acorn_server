package com.acorn.erp.domain.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;

public interface GenderGroupRepository extends JpaRepository<AgeGroup, Integer>{
	// customerId를 기준으로 존재 여부 확인
    boolean existsByCustomerId(int customerId);
}
