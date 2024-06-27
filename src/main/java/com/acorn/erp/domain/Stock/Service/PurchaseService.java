package com.acorn.erp.domain.Stock.Service;

import com.acorn.erp.domain.Stock.Entity.Purchase;
import com.acorn.erp.domain.Stock.Repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long purchaseCode) {
        Optional<Purchase> purchaseOptional = purchaseRepository.findById(purchaseCode);
        return purchaseOptional.orElse(null);
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Long purchaseCode, Purchase updatedPurchase) {
        Purchase purchase = purchaseRepository.findById(purchaseCode)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        // Update fields
        purchase.setPurchaseUnit(updatedPurchase.getPurchaseUnit());
        purchase.setPurchaseName(updatedPurchase.getPurchaseName());
        purchase.setOrderDate(updatedPurchase.getOrderDate());
        purchase.setOrderQty(updatedPurchase.getOrderQty());
        purchase.setPrice(updatedPurchase.getPrice());
        purchase.setRemark(updatedPurchase.getRemark());

        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long purchaseCode) {
        purchaseRepository.deleteById(purchaseCode);
    }
}
