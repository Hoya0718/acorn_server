package com.acorn.erp.domain.Customer.Controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.RegionGroup;
import com.acorn.erp.domain.Customer.Repository.RegionGroupRepository;
import com.acorn.erp.domain.Customer.Service.RegionGroupService;

@RestController
@RequestMapping("/api/customer")
public class RegionGroupController {
	
    @Autowired
    private RegionGroupService service;

    @Autowired
    private RegionGroupRepository repository;
    
    @GetMapping("/calculate_region_group")
    public String calculateAndInsertRegionGroup(){
        service.calculateAndInsertRegionGroup();
        return "Region group info calculated and inserted successfully";
    }
    @GetMapping("/count_region_group")
    public Map<String, Map<String, Long>> countRegionGroup(){
        return service.countCustomersByRegionGroup();
    }
    @GetMapping("/get_region_group")
    public  List<RegionGroup> getRegionGroup(){
        return repository.findAll();
    }
}