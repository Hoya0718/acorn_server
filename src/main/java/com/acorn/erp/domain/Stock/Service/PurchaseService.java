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

    public Purchase getPurchaseById(Long id) {
        Optional<Purchase> purchaseOptional = purchaseRepository.findById(id);
        return purchaseOptional.orElse(null); // orElse(null) 대신에 throw Exception을 던지는 것도 한 방법
    }

    public Purchase createPurchase(Purchase purchase) {
        // 추가적인 validation을 수행 할 수 있음 (ex. duplicate 검사 등)
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Long id, Purchase updatedPurchase) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        // Update fields
        purchase.setPurchaseCode(updatedPurchase.getPurchaseCode());
        purchase.setPurchaseUnit(updatedPurchase.getPurchaseUnit());
        purchase.setPurchaseName(updatedPurchase.getPurchaseName());
        purchase.setOrderDate(updatedPurchase.getOrderDate());
        purchase.setOrderQty(updatedPurchase.getOrderQty());
        purchase.setPrice(updatedPurchase.getPrice());
        purchase.setRemark(updatedPurchase.getRemark());

        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }
}
