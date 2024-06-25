package com.acorn.erp.domain.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
@Repository
public interface PreferenceRepository extends JpaRepository<CustomerPreferenceData, Integer> {

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