package com.acorn.erp.domain.Customer.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
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
    @GetMapping("/searchKeywordPreferenceData")
	public List<CustomerPreferenceData> searchCustomerPreferenceDataByKeyword(@RequestParam("keyword")String keyword) {
        return repository.searchCustomerPreferenceDataByKeyword(keyword);
    }
//	@GetMapping("/searchPeriodPreferenceData")
//	public List<CustomerPreferenceData> searchCustomerPreferenceDataByPeriod(
//		@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
//		@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
//		
//		Calendar calendar = Calendar.getInstance();
//	    calendar.setTime(endDate);
//	    calendar.set(Calendar.HOUR_OF_DAY, 23);
//	    calendar.set(Calendar.MINUTE, 59);
//	    calendar.set(Calendar.SECOND, 59);
//	    calendar.set(Calendar.MILLISECOND, 999);
//	    endDate = calendar.getTime();
//	    
//        return repository.findByLastPreferenceDataBetween(startDate, endDate);
//    }
}