package com.acorn.erp.domain.Customer.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;

public interface PreferenceRepository extends JpaRepository<CustomerPreferenceData, String> {

//    @Query("SELECT SUM(t.amount) FROM CustomerTransactionInfo t WHERE t.productId = :productId")
//    double sumAmountByProductId(String productId);
//
//    @Query("SELECT COUNT(t) FROM CustomerTransactionInfo t WHERE t.productId = :productId")
//    int countByProductId(String productId);
//
//    @Query("SELECT c.customerGender FROM CustomerTransactionInfo t JOIN CustomerInfo c ON t.customerId = c.customerId WHERE t.productId = :productId GROUP BY c.customerGender ORDER BY COUNT(t) DESC")
//    String findGenderPreferenceByProductId(String productId);
//
//    @Query("SELECT c.customerBirthDate FROM CustomerTransactionInfo t JOIN CustomerInfo c ON t.customerId = c.customerId WHERE t.productId = :productId")
//    List<Date> findCustomerBirthDatesByProductId(String productId);
//
//    @Query("SELECT c.customerAddr FROM CustomerTransactionInfo t JOIN CustomerInfo c ON t.customerId = c.customerId WHERE t.productId = :productId")
//    List<String> findCustomerAddressesByProductId(String productId);
}