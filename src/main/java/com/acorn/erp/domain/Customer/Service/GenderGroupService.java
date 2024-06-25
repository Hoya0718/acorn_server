package com.acorn.erp.domain.Customer.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.GenderGroup;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
import com.acorn.erp.domain.Customer.Repository.GenderGroupRepository;

@Service
public class GenderGroupService {

    @Autowired
    private GenderGroupRepository genderGroupRepository;

    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    
    // 성별 고객 수를 계산하는 메서드
    @Transactional(readOnly = true)
    public Map<String, Long> countCustomersByGenderGroup() {
        List<GenderGroup> genderGroups = genderGroupRepository.findAll();
     // 성 그룹별 고객 수를 계산하여 반환
        Map<String, Long> genderGroupCounts = genderGroups.stream()
                .collect(Collectors.groupingBy(AgeGroup::getAgeGroup, Collectors.counting()));
        // 성 그룹별 고객 수 출력
        for (Map.Entry<String, Long> entry : genderGroupCounts.entrySet()) {
            System.out.println("Gender Group: " + entry.getKey() + ", Count: " + entry.getValue());
        }
        return genderGroupCounts;
    }
}
