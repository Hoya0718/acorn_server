package com.acorn.erp.domain.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;

public interface TransactionRepository extends JpaRepository<CustomerTransactionInfo, Integer> {

    boolean existsByCustomerName(@Param("customerName") String customerName);
    boolean existsByCustomerId(@Param("customerId") int customerId);
}