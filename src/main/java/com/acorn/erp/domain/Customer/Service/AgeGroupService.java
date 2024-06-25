package com.acorn.erp.domain.Customer.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
import com.acorn.erp.domain.Customer.Util.AgeGroupUtil;

@Service
public class AgeGroupService {

	 @Autowired
	    private CustomerInfoRepository customerRepository;

	    @Autowired
	    private AgeGroupRepository ageGroupRepository;
//생년월일을 기준으로 연령그룹 구분하기
//	    @Transactional
//	    public void calculateAndInsertAgeGroup() {
//        List<String> customers = customerRepository.findAll();
//
//        for (String customer : customers) {
//        	String ageGroup = AgeGroupUtil.calculateAgeGroup(customer.getCustomerBirthDate());
//
//            AgeGroup ageGroupEntity = new AgeGroup();
//            ageGroupEntity.setAgegroup_id(UUID.randomUUID().toString());
//            ageGroupEntity.setCustomer_id(customer.getCustomer_id());
//            ageGroupEntity.setAgeGroup(ageGroup);
//
//            ageGroupRepository.save(ageGroupEntity);
//        }
//    }
//    
    //테이블에 출력하기
    //랭킹정보(최고금액거래고객/최다횟수거래고객)
}
