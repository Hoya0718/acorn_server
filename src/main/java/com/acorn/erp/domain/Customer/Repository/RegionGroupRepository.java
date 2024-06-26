package com.acorn.erp.domain.Customer.Repository;

import com.acorn.erp.domain.Customer.Entity.RegionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionGroupRepository extends JpaRepository<RegionGroup, Integer> {
	// customerId를 기준으로 존재 여부 확인
    boolean existsByCustomerId(int customerId);
}