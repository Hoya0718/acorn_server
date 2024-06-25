package com.acorn.erp.domain.Stock.Service;

import com.acorn.erp.domain.Stock.Entity.Vendor;
import com.acorn.erp.domain.Stock.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(Long id) {
    	// Optional은 NullPointerException을 방지한다
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        return vendorOptional.orElse(null); // Optional에 값이 없으면 null 반환
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Long id, Vendor updatedVendor) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found")); 

        // 업데이트할 필드들을 설정
        vendor.setVendorCode(updatedVendor.getVendorCode());
        vendor.setVendorName(updatedVendor.getVendorName());
        vendor.setVendorContact(updatedVendor.getVendorContact());
        vendor.setVendorAddress(updatedVendor.getVendorAddress());
        vendor.setVendorRemark(updatedVendor.getVendorRemark());
        vendor.setDeliverableStatus(updatedVendor.isDeliverableStatus());

        return vendorRepository.save(vendor);
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
