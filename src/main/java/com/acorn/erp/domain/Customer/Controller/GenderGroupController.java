//package com.acorn.erp.domain.Customer.Controller;
//
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
//import com.acorn.erp.domain.Customer.Service.GenderGroupService;
//
//@RestController
//@RequestMapping("/api/customer")
//public class GenderGroupController {
//	
//    @Autowired
//    private GenderGroupService service;
//
//    @GetMapping("/count_gender_group")
//    public Map<String, Long> countGenderGroup(){
//        return service.countCustomersByGenderGroup();
//    }
//}
