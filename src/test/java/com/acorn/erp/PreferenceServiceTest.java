package com.acorn.erp;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
import com.acorn.erp.domain.Customer.Service.PreferenceService;

@SpringBootTest
public class PreferenceServiceTest {

    @Autowired
    private PreferenceService preferenceService;

    @Test
    public void testCalculateOrderData() {
        preferenceService.calculateOrderData();
        List<CustomerPreferenceData> preferences = preferenceService.getCustomerPreferences();
        assertFalse(preferences.isEmpty(), "CustomerPreferenceData should not be empty");
        preferences.forEach(data -> {
            System.out.println(data);
        });
    }
}