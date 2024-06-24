package com.acorn.erp.domain.Customer.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Service.AgeGroupService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer_status")
public class AgeGroupController {
	
    @Autowired
    private AgeGroupService ageGroupService;

    @GetMapping("/calculate_age_group")
    public String calculateAndInsertAgeGroup(){
        System.out.println("Calculating and inserting age group info");
//        ageGroupService.calculateAndInsertAgeGroup();
        return "Age group info calculated and inserted successfully";
    }
}
