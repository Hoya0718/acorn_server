package com.acorn.erp.custormer;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Customer.Controller.TransactionController;
import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
import com.acorn.erp.domain.Customer.Repository.TransactionRepository;
import com.acorn.erp.domain.Customer.Service.TransactionService;

@SpringBootTest
public class TransactionTest implements CommandLineRunner {

	@Autowired
	private TransactionService service;

    @Autowired
    private TransactionRepository repository;
    
    @Autowired
    private TransactionController controller;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running AgeGroupTests...");
		test();

	};

	@Test
	public void test() {
		List<Integer> customerIds = service.getCustomerIds();
        for (int customerId : customerIds) {
            service.calculateTransactionData(customerId);
            List<CustomerTransactionInfo> preferences = service.getCustomerRank();
            assertFalse(preferences.isEmpty(), "CustomerTransactionInfo should not be empty for customerId: " + customerId);
            preferences.forEach(data -> {
                System.out.println("CustomerId: " + customerId + ", Data: " + data);
            });
        }
}
	@Test
	public void postTest() {
		List<CustomerTransactionInfo> transactionInfo = repository.findAll();
		System.out.println("데이터: "+ transactionInfo);
	}
//	@Test
//	public void updateRankings() {
//		controller.updateRankings();
//	}
	
}