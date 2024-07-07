package com.acorn.erp.domain.Customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.CustomerGrade;
import com.acorn.erp.domain.Customer.Repository.GradeRepository;

@RestController
@RequestMapping("/api/customer")
public class GradeController {

	@Autowired
	private GradeRepository repository;

	@GetMapping("/getGrade")
	public List<CustomerGrade> getAllGrade() {
		List<CustomerGrade> grade = repository.findAll();
		return grade;
	}

	// 등급없는사람에게 일괄 등급 부여하기
	@PutMapping("/grade")
	public ResponseEntity<CustomerGrade> updateCustomerGrade(@PathVariable("customerId") int customerId,
			@RequestBody CustomerGrade newInfo) {
		return repository.findByCustomerId(customerId).stream().findFirst().map(customer -> {
			customer.setCustomerGrade(newInfo.getCustomerGrade());

			repository.save(customer);

			return ResponseEntity.ok(customer);
		}).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
	}

	//신규고객에
	@PutMapping("/grade/{customerId}")
	 public ResponseEntity<CustomerGrade> setCustomerGrade(@PathVariable("customerId") int customerId, @RequestBody CustomerGrade newInfo) {
		CustomerGrade customerGrade;
           boolean exists = repository.existsByCustomerId(customerId);
           if (!exists) {
        	   customerGrade = new CustomerGrade();
        	   customerGrade.setCustomerId(newInfo.getCustomerId());
           } else {
        	   Optional<CustomerGrade> optionalCustomerGrade = repository.findByCustomerId(customerId);
               if (optionalCustomerGrade.isPresent()) {
                   customerGrade = optionalCustomerGrade.get();
               } else {
                 return ResponseEntity.notFound().build();
               }
           }
        	   customerGrade.setCustomerGrade(newInfo.getCustomerGrade());
   			
   			repository.save(customerGrade);
   			
  return ResponseEntity.ok(customerGrade);
}}
