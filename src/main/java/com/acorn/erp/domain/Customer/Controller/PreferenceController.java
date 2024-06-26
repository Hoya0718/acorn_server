package com.acorn.erp.domain.Customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acorn.erp.domain.Customer.Service.PreferenceService;

@RestController
@RequestMapping("/api/customer")
public class PreferenceController {

    @Autowired
    private PreferenceService service;
    //각 상품별로 총금액, 총거래횟수, 평점 산출
    @GetMapping("/calculate")
    public String calculateAndInsertPreferenceData() {
//        service.calculateAndInsertPreferenceData();
        return "Customer preference data calculated and inserted successfully";
    }
    //각 상품별로 가장거래를 많이한 성별그룹/연령그룹/지역그룹
    
    //최다거래상품 필터: 상품명
    
    
    //각 최다거래상품을 가장 많이 산 성별그룹/연령그룹/지역그룹

    //최고매출상품 필터: 상품명
    //각 최고매출상품을 가장 많이 산 성별그룹/연령그룹/지역그룹
}