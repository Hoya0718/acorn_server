package com.acorn.erp.domain.Customer.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acorn.erp.domain.Customer.Service.RegionGroupService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer_status")
public class RegionGroupController {
	
    @Autowired
    private RegionGroupService regionGroupService;

    @GetMapping("/calculate_region_group")
    public String calculateAndInsertRegionGroup(){
        System.out.println("Calculating and inserting region group info");
        regionGroupService.calculateAndInsertRegionGroup();
        return "Region group info calculated and inserted successfully";
    }
}