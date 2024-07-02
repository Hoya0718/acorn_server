package com.acorn.erp.domain.Customer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
@Repository("ageGroupJpaRepository")
public interface AgeGroupRepository extends JpaRepository<AgeGroup, Integer>{
	// c ustomerId를 기준으로 존재 여부 확인
    boolean existsByCustomerId(int customerId);
    
    List<AgeGroup> findByCustomerId(int customerId);
}
