package com.acorn.erp.domain.Customer.Repository;

import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TransactionRepository extends JpaRepository<CustomerTransactionInfo, String> {

//    @Query("SELECT MAX(t.transactionDate) FROM Transaction t WHERE t.customerId = :customerId")
//    Date findMaxTransactionDateByCustomerId(String customerId);
//
//    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.customerId = :customerId")
//    double sumAmountByCustomerId(String customerId);
//
//    @Query("SELECT p.productName FROM Product p WHERE p.productId = (SELECT t.productId FROM Transaction t WHERE t.customerId = :customerId GROUP BY t.productId ORDER BY SUM(t.amount) DESC LIMIT 1)")
//    String findTopSellingProductByCustomerId(String customerId);
//
//    int countByCustomerId(String customerId);
//
//    @Query("SELECT p.productName FROM Product p WHERE p.productId = (SELECT t.productId FROM Transaction t WHERE t.customerId = :customerId GROUP BY t.productId ORDER BY COUNT(t.productId) DESC LIMIT 1)")
//    String findMostPurchasedProductByCustomerId(String customerId);
}