package com.acorn.erp.domain.Customer.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acorn.erp.domain.Customer.Service.TransactionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer_status")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/calculate")
	public String calculateAndInsertTransactionInfo(){
		System.out.println("Calculating and inserting transaction info");
		transactionService.calculateAndInsertCustomerTransactionInfo();
		return "Customer transaction info calculated and inserted successfully";
	}
}
