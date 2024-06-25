package com.acorn.erp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootTest(classes = AcornServerApplication.class)
class AcornServerApplicationTests {

	@Autowired
	private CustomerInfoRepository repository;

    @PersistenceContext
    private EntityManager entityManager;
	  @Test
	  void contextLoads() {
	    }
	  @BeforeEach @Disabled
		void insertTestData() {
			LocalDateTime currentDateTime = LocalDateTime.now();
			CustomerInfo customer = new CustomerInfo();
			customer.setCustomerId(0);
			customer.setCustomerName("박승희");
			customer.setCustomerGender("여성");
			customer.setCustomerBirthDate(new Date());
			customer.setCustomerAddr("경기도 포천시 군내면");
			customer.setCustomerTel("010-8281-2856");
			customer.setRegisterDate(new Date());
			repository.save(customer);
//			
//			customer = new CustomerInfo();
//			customer.setCustomerId(0);
//			customer.setCustomer_name("김단아");
//			customer.setCustomer_gender("여성");
//			customer.setCustomer_birth_date(new Date());
//			customer.setCustomer_addr("경기도 양주시 옥정동");
//			customer.setCustomer_tel("010-1234-5678");
//			customer.setRegister_date(new Date());
//			repository.save(customer);
//			
//			customer = new CustomerInfo();
//			customer.setCustomer_id(0);
//			customer.setCustomer_name("송지환");
//			customer.setCustomer_gender("남성");
//			customer.setCustomer_birth_date(new Date());
//			customer.setCustomer_addr("경기도 포천시 신읍동");
//			customer.setCustomer_tel("010-1234-5678");
//			customer.setRegister_date(new Date());
//			repository.save(customer);
//			
//			customer = new CustomerInfo();
//			customer.setCustomer_id(0);
//			customer.setCustomer_name("이은정");
//			customer.setCustomer_gender("여성");
//			customer.setCustomer_birth_date(new Date());
//			customer.setCustomer_addr("경기도 포천시 일동면");
//			customer.setCustomer_tel("010-5555-8888");
//			customer.setRegister_date(new Date());
//			repository.save(customer);
		}
	  @Test @Disabled
	    @Transactional
	  void testRead() {
	        
			List<CustomerInfo> users =repository.findAll();
			System.out.println("데이터 갯수: "+users.size());
			
			System.out.println("모든 고객의 이름:");
	        for (CustomerInfo user : users) {
	            System.out.println(user.getCustomerName());
	        }
	  }
} 