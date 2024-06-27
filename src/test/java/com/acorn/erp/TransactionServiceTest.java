package com.acorn.erp;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
import com.acorn.erp.domain.Customer.Service.TransactionService;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService service;

    @Test
    public void testCalculateOrderData() {
        service.calculateTransactionData();
        List<CustomerTransactionInfo> preferences = service.getCustomerRank();
        assertFalse(preferences.isEmpty(), "CustomerPreferenceData should not be empty");
        preferences.forEach(data -> {
            System.out.println(data);
        });
    }
}