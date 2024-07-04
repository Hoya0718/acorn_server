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

import com.acorn.erp.domain.Stock.Entity.Purchase;
import com.acorn.erp.domain.Stock.Repository.PurchaseRepository;



@RestController
//@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase) {
    	System.out.println("추가 성공"); 
        return purchaseRepository.save(purchase);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable Long id) {
    	purchaseRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Purchase updatePurchase(@PathVariable Long id, @RequestBody Purchase purchase) {
        purchase.setId(id);
        return purchaseRepository.save(purchase);
    }
}
