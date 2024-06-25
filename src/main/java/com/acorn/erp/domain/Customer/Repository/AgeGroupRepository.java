package com.acorn.erp.domain.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acorn.erp.domain.Customer.Entity.CustomerInfo;

public interface AgeGroupRepository extends JpaRepository<CustomerInfo, Integer>{

}
