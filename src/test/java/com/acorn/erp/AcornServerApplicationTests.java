package com.acorn.erp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Customer.Controller.CustomerController;
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootTest
class AcornServerApplicationTests implements CommandLineRunner {
//	private CustomerInfo customer; 
	@Autowired
	private CustomerInfoRepository repository;
	@Autowired
	private CustomerController customerController;
	
	@Override
    public void run(String... args) throws Exception {
        System.out.println("Running AgeGroupTests...");
        testRead();
    }
	
    @PersistenceContext
    private EntityManager entityManager;
	  @Test
	  void contextLoads() {
	    }
//	  @BeforeEach
//		void insertTestData() {
//			LocalDateTime currentDateTime = LocalDateTime.now();
//			CustomerInfo customer = new CustomerInfo();
//			customer.setCustomerId(0);
//			customer.setCustomerName("박승희");
//			customer.setCustomerGender("여성");
//			customer.setCustomerBirthDate(new Date());
//			customer.setCustomerAddr("경기도 포천시 군내면");
//			customer.setCustomerTel("010-8281-2856");
//			customer.setRegisterDate(new Date());
//			repository.save(customer);
//		}
	  @Test
	    @Transactional
	  void testRead() {
	        
			List<CustomerInfo> users =repository.findAll();
			System.out.println("데이터 갯수: "+users.size());
//			System.out.println("모든 고객의 이름:");
//	        for (CustomerInfo user : users) {
//	            System.out.println(user.getCustomerName());
	        }
			
			// countCustomerGroupBy() 메서드 호출 및 결과 확인
//			Map<String, Map<String, Map<String, Map<String, Long>>>> result = customerController.countCustomerGroupBy();
//		        System.out.println("result: " + result);
//
//		        Map<String, Map<String, Map<String, Long>>>genderCounts = result.get("gender");
//		        Map<String, Map<String, Map<String, Long>>> ageCounts = result.get("age");
//		        Map<String, Map<String, Map<String, Long>>>regionCounts = result.get("region");
//
//		        System.out.println("Gender Counts: " + genderCounts);
//		        System.out.println("Age Counts: " + ageCounts);
//		        System.out.println("Region Counts: " + regionCounts);
//	  }
} 