//package com.acorn.erp.domain.Customer.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.acorn.erp.domain.Customer.Entity.AgeGroup;
//import com.acorn.erp.domain.Customer.Entity.CustomerGrade;
//import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
//import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
//import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
//import com.acorn.erp.domain.Customer.Repository.GradeRepository;
//
//@Service
//public class CustomerDataService {
//	
//	@Autowired
//    private CustomerInfoRepository customerInfoRepository;
//    @Autowired
//    private AgeGroupRepository ageGroupRepository;
//    @Autowired
//    private GradeRepository customerGradeRepository;
//    
//    
//    public List<CustomerInfo> getAllCustomers() {
//        return customerInfoRepository.findAll();
//    }
//	public AgeGroup getAgeGroupByCustomerId(int customerId) {
//        return ageGroupRepository.findByCustomerId(customerId).stream().findFirst().orElse(null);
//    }
//	public CustomerGrade getGradeByCustomerId(int customerId) {
//        return customerGradeRepository.findByCustomerId(customerId).stream().findFirst().orElse(null);
//    }
//}
