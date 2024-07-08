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


    /*
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryTable> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public InventoryTable getInventoryByCode(Long itemCode) {
        return inventoryRepository.findByItemCode(itemCode).orElse(null);
    }

    public InventoryTable createInventory(InventoryTable inventory) {
        return inventoryRepository.save(inventory);
    }

    public InventoryTable updateInventory(Long itemCode, InventoryTable inventory) {
        Optional<InventoryTable> existingInventory = inventoryRepository.findByItemCode(itemCode);
        if (existingInventory.isPresent()) {
            InventoryTable updatedInventory = existingInventory.get();
            updatedInventory.setItemName(inventory.getItemName());
            updatedInventory.setItemQty(inventory.getItemQty());
            updatedInventory.setStockOut(inventory.getStockOut());
            updatedInventory.setStockQty(inventory.getStockQty());
            return inventoryRepository.save(updatedInventory);
        }
        return null;
    }

    public void deleteInventory(Long itemCode) {
        inventoryRepository.deleteByItemCode(itemCode);
    }
}
*/
