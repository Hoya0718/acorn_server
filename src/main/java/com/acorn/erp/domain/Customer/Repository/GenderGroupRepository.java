package com.acorn.erp.domain.Customer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.GenderGroup;

@Repository
public interface GenderGroupRepository extends JpaRepository<GenderGroup, Integer>{
	// customerId를 기준으로 존재 여부 확인
    boolean existsByCustomerId(int customerId);
    List<GenderGroup> findByCustomerId(int customerId);
}
