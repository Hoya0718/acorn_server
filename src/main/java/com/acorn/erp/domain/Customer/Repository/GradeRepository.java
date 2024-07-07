package com.acorn.erp.domain.Customer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.CustomerGrade;

@Repository
public interface GradeRepository extends JpaRepository<CustomerGrade, Integer> {
	// customerId를 기준으로 존재 여부 확인
    boolean existsByCustomerId(int customerId);
    
    Optional<CustomerGrade> findByCustomerId(int customerId);
}