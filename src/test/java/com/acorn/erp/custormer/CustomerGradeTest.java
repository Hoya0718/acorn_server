package com.acorn.erp.custormer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.acorn.erp.domain.Customer.Service.GradeService;


@SpringBootTest
public class CustomerGradeTest implements CommandLineRunner {

    @Autowired
    private  GradeService service;

        @Override
        public void run(String... args) throws Exception {
        	System.out.println("Running Customer Grade Tests...");
            test();
   
        };
        @Test
        public void test() {
            service.applyDefaultGradeToExistingCustomers();
        }
}