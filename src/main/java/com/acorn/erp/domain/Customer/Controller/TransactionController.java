package com.acorn.erp.domain.Customer.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
import com.acorn.erp.domain.Customer.Service.TransactionService;

@RestController
@RequestMapping("/api/customer")
public class TransactionController {
	
	@Autowired
	private TransactionService service;
	
	public String calculateTransactionData(){
		service.calculateTransactionData();
		return "Customer transaction info calculated and inserted successfully";
	}
	@GetMapping("/getListRankTable")
    public List<CustomerTransactionInfo> getListRankTable() {
    	return service.getCustomerRank();
    }
}
