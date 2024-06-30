package com.acorn.erp.domain.Customer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acorn.erp.domain.Customer.Entity.RegionGroup;

public interface RegionGroupRepository extends JpaRepository<RegionGroup, Integer> {
	// customerId를 기준으로 존재 여부 확인
    boolean existsByCustomerId(int customerId);
    List<RegionGroup> findByCustomerId(int customerId);
}