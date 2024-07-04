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
import com.acorn.erp.domain.Customer.Repository.PreferenceRepository;
import com.acorn.erp.domain.Customer.Service.PreferenceService;

@RestController
@RequestMapping("/api/customer")
public class PreferenceController {

    @Autowired
    private PreferenceService service;
    @Autowired
    private PreferenceRepository repository;
    
    //각 상품별로 총금액, 총거래횟수, 평점 산출
    public String calculateOrderData() {
        service.calculateOrderData();
        return "Customer preference data calculated and inserted successfully";
    }
    @GetMapping("/getListProdTable")
    public List<CustomerPreferenceData> getListProdTable() {
    	return service.getCustomerPreferences();
    }
    @PostMapping("/getListProdTable")
    public  Page<CustomerPreferenceData> getListProdPageInfo(Pageable pageable) {
    	Page<CustomerPreferenceData> preferenceData = repository.findAll(pageable);
    	return preferenceData;
    }
    @GetMapping("/getTop3ByTotalAmount")
    public List<CustomerPreferenceData> getTop3ByTotalAmount() {
        return service.getTop3ByTotalAmount();
    }
    @GetMapping("/getTop3ByTotalCount")
    public List<CustomerPreferenceData> getTop3ByTotalCount() {
        return service.getTop3ByTotalCount();
    }
    @GetMapping("/getTop3ByRating")
    public List<CustomerPreferenceData> getTop3ByRating() {
        return service.getTop3ByRating();
    }
}