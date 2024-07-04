
package com.acorn.erp.domain.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
import com.acorn.erp.domain.Customer.Repository.TransactionRepository;
import com.acorn.erp.domain.Customer.Service.TransactionService;

@RestController
@RequestMapping("/api/customer")
public class TransactionController {

	@Autowired
	private TransactionService service;

    @Autowired
    private TransactionRepository repository;

	public String calculateTransactionData(int customerId) {
		service.calculateTransactionData(customerId);
		return "Customer transaction info calculated and inserted successfully";
	}

	@GetMapping("/getListRankTable")
	public List<CustomerTransactionInfo> getListRankTable() {
		return service.getCustomerRank();
	}
	@PostMapping("/getListRankTable")
    public  Page<CustomerTransactionInfo> getListRankPageInfo(Pageable pageable) {
    	Page<CustomerTransactionInfo> transactionInfo = repository.findAll(pageable);
    	return transactionInfo;
    }
	@GetMapping("/getTop10ByTotalAmount")
	public List<CustomerTransactionInfo> getTop10ByTotalAmount() {
		return service.getTop10ByTotalAmount();
	}

	@GetMapping("/getTop10ByTotalCount")
	public List<CustomerTransactionInfo> getTop10ByTotalCount() {
		return service.getTop10ByTotalCount();
	}
}
