package com.acorn.erp.domain.Sales.Service;

import com.acorn.erp.domain.Sales.Entity.InventoryTable;
import com.acorn.erp.domain.Sales.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryTable> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public InventoryTable createInventoryItem(InventoryTable inventory) {
        inventory.calculateStockQty(); // 재고 합계 계산
        return inventoryRepository.save(inventory);
    }

    public Optional<InventoryTable> updateInventoryItem(Long no, InventoryTable inventory) {
        Optional<InventoryTable> existingInventory = inventoryRepository.findById(no);
        if (existingInventory.isPresent()) {
            InventoryTable updatedInventory = existingInventory.get();
            updatedInventory.setItemCode(inventory.getItemCode());
            updatedInventory.setItemName(inventory.getItemName());
            updatedInventory.setItemQty(inventory.getItemQty());
            updatedInventory.setStockOut(inventory.getStockOut());
            updatedInventory.setStockQty(inventory.getStockQty());
            updatedInventory.calculateStockQty(); // 재고 합계 계산
            return Optional.of(inventoryRepository.save(updatedInventory));
        }
        return Optional.empty();
    }

    public boolean deleteInventoryItem(Long no) {
        if (inventoryRepository.existsById(no)) {
            inventoryRepository.deleteById(no);
            return true;
        }
        return false;
    }
}
