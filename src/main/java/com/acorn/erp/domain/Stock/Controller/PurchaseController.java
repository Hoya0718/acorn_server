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

import com.acorn.erp.domain.Stock.Entity.Purchase;
import com.acorn.erp.domain.Stock.Entity.Vendor;
import com.acorn.erp.domain.Stock.Repository.PurchaseRepository;
import com.acorn.erp.domain.Stock.Service.PurchaseService;
@Controller
@RequestMapping("/api/purchase")
public class PurchaseController {

	 @Autowired
    private final PurchaseService purchaseService;
	 @Autowired
	 private PurchaseRepository repository;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/list")
    public @ResponseBody List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }
    
  //페이지네이션
    @GetMapping("/listPage")
    public @ResponseBody Page<Purchase> getAllPurchasePage(Model model, Pageable pageable) {
    	Page<Purchase>pages =  repository.findAll(pageable);
    	System.out.println(pages);
    	return pages;
    }
    
    @GetMapping("/{code}")
    public String getPurchaseById(@PathVariable("code") Long code, Model model) {
        Purchase purchase = purchaseService.getPurchaseById(code);
        model.addAttribute("purchase", purchase);
        return "purchase/list"; 
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "purchase/add";
    }

    @PostMapping("/add")
    public @ResponseBody Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchaseService.createPurchase(purchase);
    }

    @GetMapping("/edit/{code}")
    public String showEditForm(@PathVariable Long code, Model model) {
        Purchase purchase = purchaseService.getPurchaseById(code);
        model.addAttribute("purchase", purchase);
        return "purchase/edit"; 
    }

    @PutMapping("/{code}")
    public @ResponseBody Purchase updatePurchase(@PathVariable("code") Long code, @RequestBody Purchase updatedPurchase) {
        return purchaseService.updatePurchase(code, updatedPurchase);
    }

    @DeleteMapping("/{code}")
    public @ResponseBody String deletePurchase(@PathVariable("code") Long code) {
        purchaseService.deletePurchase(code);
        return "Purchase deleted successfully";
    }
}
