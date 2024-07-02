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

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    // 모든 구매 목록 조회
    @GetMapping("/list")
    public @ResponseBody List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    // 특정 ID에 해당하는 구매 정보 조회
    @GetMapping("/{id}")
    public @ResponseBody Purchase getPurchaseById(@PathVariable("id") Long id) {
        return purchaseService.getPurchaseById(id);
    }

    // 구매 추가 폼 보여주기
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("purchase", new Purchase());
        return "purchase/add"; // purchase/add.html로 이동
    }

    // 새로운 구매 생성
    @PostMapping("/add")
    public @ResponseBody Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchaseService.createPurchase(purchase);
    }

    // 구매 수정 폼 보여주기
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Purchase purchase = purchaseService.getPurchaseById(id);
        model.addAttribute("purchase", purchase);
        return "purchase/edit"; // purchase/edit.html로 이동
    }

    // 구매 업데이트
    @PutMapping("/{id}")
    public @ResponseBody void updatePurchase(@PathVariable("id") Long id, @ModelAttribute("purchase") Purchase updatedPurchase) {
        purchaseService.updatePurchase(id, updatedPurchase);
    }

    // 구매 삭제
    @DeleteMapping("/{id}")
    public @ResponseBody String deletePurchase(@PathVariable("id") Long id) {
        purchaseService.deletePurchase(id);
        return "Purchase deleted successfully";
    }
}
