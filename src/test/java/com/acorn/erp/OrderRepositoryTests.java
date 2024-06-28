package com.acorn.erp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Sales.OrderRepository;
import com.acorn.erp.domain.Sales.OrderTable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest(classes = AcornServerApplication.class)
class OrderRepositoryTests {

	@Autowired
	private OrderRepository repository;

    @PersistenceContext
    private EntityManager entityManager;
	  @Test
	  void contextLoads() {
	    }

	  @Test
	  void testRead() {
			List<OrderTable> order =repository.findAll();
			System.out.println("데이터 갯수: "+order.size());
			
//			System.out.println("모든 고객의 이름:");
//	        for (CustomerInfo user : users) {
//	            System.out.println(user.getCustomerName());
//	        }
	  }
	  
	  @BeforeEach
		void insertTestData() {
			LocalDateTime currentDateTime = LocalDateTime.now();
			OrderTable customer = new OrderTable();
			customer.setOrderNum(2001);
			customer.setItemCode("2001");
			customer.setItemName("단팥빵");
			customer.setCustomerId(2500);
			customer.setCustomerName("박승희");
			customer.setCustomerTel("010-8281-2856");
			customer.setCustomerAddr("경기도 포천시 군내면");
			customer.setPrice(50000);
			customer.setItemQty(1);
			customer.setDeliveryFee(1000);
			customer.setTotalPrice(51000);
			customer.setOrderDate(new Date());
			customer.setItemReq("");
			customer.setOrderStatus("Delivered");
			repository.save(customer);
		}
} 