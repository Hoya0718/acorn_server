package com.acorn.erp.domain.Customer.Repository;

import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TransactionRepository extends JpaRepository<CustomerTransactionInfo, Integer> {


}