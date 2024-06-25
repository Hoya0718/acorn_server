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

import com.acorn.erp.domain.Stock.Entity.Vendor;
import com.acorn.erp.domain.Stock.Service.VendorService;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    // 모든 vendor 리스트 읽어오기
    @GetMapping
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = vendorService.getAllVendors();
        return vendors;
    }

    // id로 vendor 조회
    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    // vendor 추가
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }
    
    // id로 vendor 수정 
    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {
        Vendor vendor = vendorService.updateVendor(id, updatedVendor);
        System.out.println("수정완료");
        return vendor;
    }

    // id로 vendor 삭제
    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
    }
}
