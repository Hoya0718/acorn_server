package com.acorn.erp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Customer.Service.PreferenceService;


@SpringBootTest
public class CustomerGradeTest implements CommandLineRunner {

    @Autowired
    private PreferenceService service;

        @Override
        public void run(String... args) throws Exception {
        	System.out.println("Running AgeGroupTests...");
            test();
        	
        };
        @Test
        public void test() {
            service.calculateOrderData();
        }
}