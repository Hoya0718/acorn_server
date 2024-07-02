/*
package com.acorn.erp.domain.Customer.Util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Service.PreferenceService;

@Component
public class PreferenceDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PreferenceService preferenceService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
    preferenceService.calculateOrderData();
         
    }
}
*/