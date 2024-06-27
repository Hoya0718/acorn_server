package com.acorn.erp.domain.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
import com.acorn.erp.domain.Customer.Repository.PreferenceRepository;
import com.acorn.erp.domain.Customer.Service.PreferenceService;

@RestController
@RequestMapping("/api/customer")
public class PreferenceController {

    @Autowired
    private PreferenceService service;
    
    //각 상품별로 총금액, 총거래횟수, 평점 산출
    //@GetMapping("/calculate")
    public String calculateOrderData() {
        service.calculateOrderData();
        return "Customer preference data calculated and inserted successfully";
    }
    @GetMapping("/getListProdTable")
    public List<CustomerPreferenceData> getListProdTable() {
    	return service.getCustomerPreferences();
    }
}