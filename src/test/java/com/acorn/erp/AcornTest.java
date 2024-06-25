package com.acorn.erp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acorn.erp.domain.Stock.Entity.Purchase;
import com.acorn.erp.domain.Stock.Repository.PurchaseRepository;


@SpringBootTest
public class AcornTest {
	@Autowired
	PurchaseRepository purchaseRepository;

	@Test
	void insertTestData() {
		Purchase purchase = new Purchase();
		purchase.setId(0L);
		purchase.setItemCode("#123");
		purchase.setPurchaseName("peach");
		purchase.setPurchaseUnit("kg");
		purchase.setOrderDate("2020-12-12");
		purchase.setOrderQty(30);
		purchase.setPrice(30000L);
		purchase.setRemark("이상없음");
		purchaseRepository.save(purchase);
	}
	
}
