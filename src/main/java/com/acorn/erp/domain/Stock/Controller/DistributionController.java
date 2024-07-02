package com.acorn.erp.domain.Stock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Stock.Entity.Distribution;
import com.acorn.erp.domain.Stock.Service.DistributionService;

@RestController
@RequestMapping("/api/distribution")
public class DistributionController {

    private final DistributionService distributionService;

    @Autowired
    public DistributionController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    @GetMapping("/list")
    public List<Distribution> getAllDistributions() {
        return distributionService.getAllDistributions();
    }

    @GetMapping("/{id}")
    public Distribution getDistributionById(@PathVariable("id") Long id) {
        return distributionService.getDistributionById(id);
    }

    @PostMapping("/add")
    public Distribution createDistribution(@RequestBody Distribution distribution) {
        return distributionService.createDistribution(distribution);
    }

    @PutMapping("/{id}")
    public Distribution updateDistribution(@PathVariable("id") Long id, @RequestBody Distribution updatedDistribution) {
        return distributionService.updateDistribution(id, updatedDistribution);
    }

    @DeleteMapping("/{id}")
    public void deleteDistribution(@PathVariable("id") Long id) {
        distributionService.deleteDistribution(id);
    }
}
