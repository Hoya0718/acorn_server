package com.acorn.erp.domain.Customer.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
@Repository
public interface PreferenceRepository extends JpaRepository<CustomerPreferenceData, Integer> {

    boolean existsByItemName(String itemName);
    
    @Query("SELECT u FROM CustomerPreferenceData u WHERE u.itemName LIKE %:keyword%")
	List<CustomerPreferenceData> searchCustomerPreferenceDataByKeyword(@Param("keyword") String keyword);
	
}