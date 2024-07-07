package com.acorn.erp.domain.Sales.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Sales.Entity.InventoryTable;
import com.acorn.erp.domain.Sales.Repository.InventoryRepository;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryTable> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public InventoryTable getInventoryByCode(Long itemCode) {
        return inventoryRepository.findById(itemCode).orElse(null);
    }

    public InventoryTable createInventory(InventoryTable inventory) {
        return inventoryRepository.save(inventory);
    }

    public InventoryTable updateInventory(Long itemCode, InventoryTable inventory) {
        if (inventoryRepository.existsById(itemCode)) {
            return inventoryRepository.save(inventory);
        } else {
            throw new RuntimeException("Item not found");
        }
    }

    public void deleteInventory(Long itemCode) {
        inventoryRepository.deleteById(itemCode);
    }
}
