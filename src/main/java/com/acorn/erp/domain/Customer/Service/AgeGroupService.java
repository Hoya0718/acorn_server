package com.acorn.erp.domain.Customer.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
import com.acorn.erp.domain.Customer.Util.AgeGroupUtil;

@Service
public class AgeGroupService {

    @Autowired
    private AgeGroupRepository ageGroupRepository;
    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    //생년월일을 기준으로 연령그룹 구분하기
	@Transactional
	public void calculateAndInsertAgeGroup() {
		List<CustomerInfo> customers = customerInfoRepository.findAll();
		System.out.println("Found " + customers.size() + " age groups in the database.");
        
		for (CustomerInfo customer : customers) {
			 // 고객이 이미 age_group 테이블에 있는지 확인
            boolean exists = ageGroupRepository.existsByCustomerId(customer.getCustomerId());
            if (!exists) {
			String ageGroup = AgeGroupUtil.calculateAgeGroup(customer.getCustomerBirthDate());

			AgeGroup ageGroupEntity = new AgeGroup();
			ageGroupEntity.setCustomerId(customer.getCustomerId());
			ageGroupEntity.setAgeGroup(ageGroup);
			
			ageGroupRepository.save(ageGroupEntity);
			}
            
		 
		}
	}
    //새로운고객 저장용 계산 메서드
    @Transactional
    public void calculateAndInsertAgeGroupForCustomer(CustomerInfo customer) {
        boolean exists = ageGroupRepository.existsByCustomerId(customer.getCustomerId());
        if (!exists) {
            String ageGroup = AgeGroupUtil.calculateAgeGroup(customer.getCustomerBirthDate());
            
            AgeGroup ageGroupEntity = new AgeGroup();
            ageGroupEntity.setCustomerId(customer.getCustomerId());
            ageGroupEntity.setAgeGroup(ageGroup);
            
            ageGroupRepository.save(ageGroupEntity);
        }
    }
    // 새로운 고객시 저장메서드 호출
    @Transactional
    public void addNewCustomer(CustomerInfo customerInfo) {
        customerInfoRepository.save(customerInfo);
        calculateAndInsertAgeGroupForCustomer(customerInfo);
    }
    
    // 연령 그룹별 고객 수를 계산하는 메서드
    @Transactional(readOnly = true)
    public Map<String, Long> countCustomersByAgeGroup() {
        List<AgeGroup> ageGroups = ageGroupRepository.findAll();
     // 연령 그룹별 고객 수를 계산하여 반환
        Map<String, Long> ageGroupCounts = ageGroups.stream()
                .collect(Collectors.groupingBy(AgeGroup::getAgeGroup, Collectors.counting()));
        // 각 연령 그룹별 고객 수 출력
//        for (Map.Entry<String, Long> entry : ageGroupCounts.entrySet()) {
//            System.out.println("Age Group: " + entry.getKey() + ", Count: " + entry.getValue());
//        }
        return ageGroupCounts;
    }
}
