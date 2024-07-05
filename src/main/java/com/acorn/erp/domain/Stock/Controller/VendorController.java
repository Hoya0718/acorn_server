package com.acorn.erp.domain.Stock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acorn.erp.domain.Stock.Entity.Vendor;
import com.acorn.erp.domain.Stock.Repository.VendorRepository;
import com.acorn.erp.domain.Stock.Service.VendorService;

@Controller
@RequestMapping("api/vendor")
public class VendorController {
    
    private final VendorService vendorService;
    
    @Autowired
    private VendorRepository repository;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // 모든 vendor 리스트 읽어오기
    @GetMapping("/list")
    public @ResponseBody List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
    
    //페이지네이션
    @GetMapping("/listPage")
    public @ResponseBody Page<Vendor> getAllVendorsPage(Model model, Pageable pageable) {
    	Page<Vendor>pages =  repository.findAll(pageable);
    	System.out.println(pages);
    	return pages;
    }

    // id로 vendor 조회
    @GetMapping("/{code}")
    public String getVendorById(@PathVariable("code") Long code, Model model) {
        Vendor vendor = vendorService.getVendorById(code);
        model.addAttribute("vendor", vendor);
        return "vendor/list"; // 이동할 상세 페이지의 경로와 이름
    }

    // vendor 추가 폼 이동
    @GetMapping("/add")
    public String showAddForm() {
        return "vendor/add"; // 이동할 추가 폼 페이지의 경로와 이름
    }

    // vendor 추가
    @PostMapping("/add")
    public @ResponseBody Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }
    
    // id로 vendor 수정 폼 이동
    @GetMapping("/edit/{code}")
    public String showEditForm(@PathVariable Long code, Model model) {
        Vendor vendor = vendorService.getVendorById(code);
        model.addAttribute("vendor", vendor);
        return "vendor/edit"; // 이동할 수정 폼 페이지의 경로와 이름
    }

    // code로 수정
    @PutMapping("/{code}")
    public @ResponseBody Vendor updateVendor(@PathVariable("code") Long code, @RequestBody Vendor updatedVendor) {
        // code를 사용하여 업데이트 로직 수행
        return vendorService.updateVendor(code, updatedVendor);
    }

    // id로 vendor 삭제
    @DeleteMapping("/{code}")
    public @ResponseBody String deleteVendor(@PathVariable("code") Long code) {
        vendorService.deleteVendor(code);
        return "Vendor deleted successfully";
    }
}
