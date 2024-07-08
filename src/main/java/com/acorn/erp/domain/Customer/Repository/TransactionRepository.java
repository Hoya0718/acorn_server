package com.acorn.erp.domain.Customer.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;

public interface TransactionRepository extends JpaRepository<CustomerTransactionInfo, Integer> {

    boolean existsByCustomerName(@Param("customerName") String customerName);

    boolean existsByCustomerId(@Param("customerId") int customerId);
    
    @Query("SELECT u FROM CustomerTransactionInfo u WHERE u.customerName LIKE %:keyword% OR u.topSellingProduct LIKE %:keyword% OR u.mostPurchasedProduct LIKE %:keyword%")
	List<CustomerTransactionInfo> searchCustomerTransactionInfoByKeyword(@Param("keyword") String keyword);
	
    @Query("SELECT u FROM CustomerTransactionInfo u WHERE u.lastTransactionDate BETWEEN :startDate AND :endDate")
    List< CustomerTransactionInfo> findByLastTransactionDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}