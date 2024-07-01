package com.acorn.erp.custormer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Customer.Service.AgeGroupService;


@SpringBootTest
public class AgeGroupTests implements CommandLineRunner {

    @Autowired
    private AgeGroupService service;

        @Override
        public void run(String... args) throws Exception {
        	System.out.println("Running AgeGroupTests...");
            testCalculateAndInsertAgeGroup();
        	
        };
        @Test
        public void testCalculateAndInsertAgeGroup() {
            System.out.println("Calculating and inserting age groups...");
            service.calculateAndInsertAgeGroup();
            System.out.println("Counting customers by age group...");
            service.countCustomersByAgeGroup();
        }
}