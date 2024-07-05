package com.acorn.erp.domain.Stock.Service;

import com.acorn.erp.domain.Stock.Entity.Distribution;
import com.acorn.erp.domain.Stock.Repository.DistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionService {
//
    @Autowired
    private DistributionRepository distributionRepository;

    public List<Distribution> getAllDistributions() {
        return distributionRepository.findAll();
    }

    public Distribution saveDistribution(Distribution distribution) {
        return distributionRepository.save(distribution);
    }

    public void deleteDistribution(Long id) {
        distributionRepository.deleteById(id);
    }

    public Distribution updateDistribution(Long id, Distribution distribution) {
        distribution.setId(id);
        return distributionRepository.save(distribution);
    }
}