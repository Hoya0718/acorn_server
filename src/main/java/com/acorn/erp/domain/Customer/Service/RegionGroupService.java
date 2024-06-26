package com.acorn.erp.domain.Customer.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Entity.RegionGroup;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
import com.acorn.erp.domain.Customer.Repository.RegionGroupRepository;

@Service
public class RegionGroupService {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    @Autowired
    private RegionGroupRepository regionGroupRepository;
    @Transactional
    public void calculateAndInsertRegionGroup() {
    	
        List<CustomerInfo> customers = customerInfoRepository.findAll();
       
        for (CustomerInfo customer : customers) {
        boolean exists = regionGroupRepository.existsByCustomerId(customer.getCustomerId());
        if (!exists) {
            String[] addressParts = customer.getCustomerAddr().split(" ");
            String regiongroupProvince = addressParts.length > 0 ? addressParts[0] : "";
            String regiongroupCity = addressParts.length > 1 ? addressParts[1] : "";
            String regiongroupTown = addressParts.length > 2 ? addressParts[2] : "";

            RegionGroup regionGroup = new RegionGroup();
            regionGroup.setCustomerId(customer.getCustomerId());
            regionGroup.setRegiongroupProvince(regiongroupProvince);
            regionGroup.setRegiongroupCity(regiongroupCity);
            regionGroup.setRegiongroupTown(regiongroupTown);

            regionGroupRepository.save(regionGroup);
        }
        }
    }
    @Transactional
    public void calculateAndInsertRegionGroupForCustomer(CustomerInfo customer) {
        boolean exists = regionGroupRepository.existsByCustomerId(customer.getCustomerId());
        if (!exists) {
        	String[] addressParts = customer.getCustomerAddr().split(" ");
            String regiongroupProvince = addressParts.length > 0 ? addressParts[0] : "";
            String regiongroupCity = addressParts.length > 1 ? addressParts[1] : "";
            String regiongroupTown = addressParts.length > 2 ? addressParts[2] : "";

            RegionGroup regionGroup = new RegionGroup();
            regionGroup.setCustomerId(customer.getCustomerId());
            regionGroup.setRegiongroupProvince(regiongroupProvince);
            regionGroup.setRegiongroupCity(regiongroupCity);
            regionGroup.setRegiongroupTown(regiongroupTown);

            regionGroupRepository.save(regionGroup);
        }
    }
    @Transactional
    public void addNewCustomer(CustomerInfo customerInfo) {
        customerInfoRepository.save(customerInfo);
        calculateAndInsertRegionGroupForCustomer(customerInfo);
    }
    @Transactional(readOnly = true)
    public Map<String, Map<String, Long>> countCustomersByRegionGroup() {
        List<RegionGroup> regionGroups = regionGroupRepository.findAll();
        // 연령 그룹별 고객 수를 계산하여 반환
        Map<String, Long> regionGroupProvinceCounts = regionGroups.stream()
                .collect(Collectors.groupingBy(RegionGroup::getRegiongroupProvince, Collectors.counting()));
        Map<String, Long> regionGroupCityCounts = regionGroups.stream()
                .collect(Collectors.groupingBy(RegionGroup::getRegiongroupCity, Collectors.counting()));
        Map<String, Long> regionGroupTownCounts = regionGroups.stream()
                .collect(Collectors.groupingBy(RegionGroup::getRegiongroupTown, Collectors.counting()));
        
        Map<String, Map<String, Long>> result = new HashMap<>();
        result.put("Province", regionGroupProvinceCounts);
        result.put("City", regionGroupCityCounts);
        result.put("Town", regionGroupTownCounts);
        
        // 각 연령 그룹별 고객 수 출력
        for (Map.Entry<String, Long> entry : regionGroupProvinceCounts.entrySet()) {
            System.out.println("Region Group: " + entry.getKey() + ", Count: " + entry.getValue());
        }
        return result;
    }
}
