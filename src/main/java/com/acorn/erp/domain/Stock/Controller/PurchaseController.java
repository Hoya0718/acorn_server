package com.acorn.erp.domain.Stock.Controller;

import com.acorn.erp.domain.Stock.Entity.Purchase;
import com.acorn.erp.domain.Stock.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/purchase")
public class PurchaseController {

	 @Autowired
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/list")
    public @ResponseBody List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
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
