package com.acorn.erp.domain.Stock.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Stock.Entity.Distribution;
import com.acorn.erp.domain.Stock.Repository.DistributionRepository;

@Service
public class DistributionService {

    private final DistributionRepository distributionRepository;

    @Autowired
    public DistributionService(DistributionRepository distributionRepository) {
        this.distributionRepository = distributionRepository;
    }

    public List<Distribution> getAllDistributions() {
        return distributionRepository.findAll();
    }

    public Distribution getDistributionById(Long id) {
        Optional<Distribution> distributionOptional = distributionRepository.findById(id);
        return distributionOptional.orElse(null);
    }

    public Distribution createDistribution(Distribution distribution) {
        return distributionRepository.save(distribution);
    }

    public Distribution updateDistribution(Long id, Distribution updatedDistribution) {
        Optional<Distribution> distributionOptional = distributionRepository.findById(id);
        if (distributionOptional.isPresent()) {
            Distribution existingDistribution = distributionOptional.get();
            // Update fields of existingDistribution with updatedDistribution
            existingDistribution.setDistributionCode(updatedDistribution.getDistributionCode());
            existingDistribution.setDistributionUnit(updatedDistribution.getDistributionUnit());
            existingDistribution.setReceiptDate(updatedDistribution.getReceiptDate());
            existingDistribution.setOrderQty(updatedDistribution.getOrderQty());
            existingDistribution.setInitialQty(updatedDistribution.getInitialQty());
            existingDistribution.setReceivedQty(updatedDistribution.getReceivedQty());
            existingDistribution.setReleaseQty(updatedDistribution.getReleaseQty());
            existingDistribution.setCurrentQty(updatedDistribution.getCurrentQty());
            existingDistribution.setExpectedReceiptDate(updatedDistribution.getExpectedReceiptDate());

            return distributionRepository.save(existingDistribution);
        } else {
            return null; // Handle case where distribution with given id is not found
        }
    }

    public void deleteDistribution(Long id) {
        distributionRepository.deleteById(id);
    }
}
