package com.acorn.erp.custormer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Customer.Service.GenderGroupService;

@SpringBootTest
public class GenderGroupTest implements CommandLineRunner {

	@Autowired
	private GenderGroupService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running AgeGroupTests...");
		test();

	};

	@Test
	public void test() {
		System.out.println("Calculating and inserting age groups...");
		service.countCustomersByGenderGroup();
	}
}