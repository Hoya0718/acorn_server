package com.acorn.erp.domain.Customer.Service;

import java.util.List;
import java.util.UUID;

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
//        List<CustomerInfo> customers = customerInfoRepository.findAll();
//
//        for (CustomerInfo customer : customers) {
//            String[] addressParts = customer.getCustomerAddr().split(" ");
//            String regiongroupProvince = addressParts.length > 0 ? addressParts[0] : "";
//            String regiongroupCity = addressParts.length > 1 ? addressParts[1] : "";
//            String regiongroupTown = addressParts.length > 2 ? addressParts[2] : "";
//
//            RegionGroup regionGroup = new RegionGroup();
//            regionGroup.setRegiongroupId(UUID.randomUUID().toString());
//            regionGroup.setCustomerId(customer.getCustomerId());
//            regionGroup.setRegiongroupProvince(regiongroupProvince);
//            regionGroup.setRegiongroupCity(regiongroupCity);
//            regionGroup.setRegiongroupTown(regiongroupTown);
//
//            regionGroupRepository.save(regionGroup);
//        }
    }
}
