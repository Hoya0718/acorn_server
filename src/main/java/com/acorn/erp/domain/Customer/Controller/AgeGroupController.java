package com.acorn.erp.domain.Customer.Controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
import com.acorn.erp.domain.Customer.Service.AgeGroupService;

@RestController
@RequestMapping("/api/customer")
public class AgeGroupController {
	
    @Autowired
    private AgeGroupService service;

    @Autowired
    private AgeGroupRepository repository;
    
    @GetMapping("/calculate_age_group")
    public String calculateAndInsertAgeGroup(){
        service.calculateAndInsertAgeGroup();
        return "Age group info calculated and inserted successfully";
    }
    @GetMapping("/count_age_group")
    public Map<String, Long> countAgeGroup(){
        return service.countCustomersByAgeGroup();
    }

    @GetMapping("/get_age_group")
    public List<AgeGroup> getAgeGroup(){
        return repository.findAll();
    }
}
