package com.acorn.erp.domain.Customer.Controller;


import java.util.List;

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
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Repository.GradeRepository;

@RestController
@RequestMapping("/api/customer")
public class GradeController {

    @Autowired
    private GradeRepository repository;
    
    @GetMapping("/getGrade")
    public List<CustomerGrade> getAllGrade(){
    	List<CustomerGrade> grade = repository.findAll();
        return grade;
    }
    @PutMapping("/grade/{customerId}")
	 public ResponseEntity<CustomerGrade> updateCustomerGrade(@PathVariable("customerId") int customerId, @RequestBody CustomerGrade newInfo) {
       return repository.findById(customerId)
               .map(customer -> {
                   // Update customer information
                   customer.setCustomerGrade (newInfo.getCustomerGrade());
                   
                   repository.save(customer);
                   
                   return ResponseEntity.ok(customer);
               })
               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
   }
}
