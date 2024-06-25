package com.acorn.erp.domain.Customer.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acorn.erp.domain.Customer.Service.PreferenceService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer_preference")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @GetMapping("/calculate")
    public String calculateAndInsertCustomerPreferenceData() {
        System.out.println("Calculating and inserting customer preference data");
        preferenceService.calculateAndInsertCustomerPreferenceData();
        return "Customer preference data calculated and inserted successfully";
    }
}