package com.acorn.erp.domain.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
@Repository
public interface PreferenceRepository extends JpaRepository<CustomerPreferenceData, Integer> {

    boolean existsByItemName(String itemName);
    
}