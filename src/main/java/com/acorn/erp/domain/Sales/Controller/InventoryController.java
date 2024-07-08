package com.acorn.erp.domain.Sales.Controller;

import com.acorn.erp.domain.Sales.Entity.InventoryTable;
import com.acorn.erp.domain.Sales.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<InventoryTable> getAllInventoryItems() {
        return inventoryService.getAllInventoryItems();
    }

    @PostMapping
    public InventoryTable createInventoryItem(@RequestBody InventoryTable inventory) {
        return inventoryService.createInventoryItem(inventory);
    }

    @PutMapping("/{no}")
    public ResponseEntity<InventoryTable> updateInventoryItem(@PathVariable Long no, @RequestBody InventoryTable inventory) {
        Optional<InventoryTable> updatedInventory = inventoryService.updateInventoryItem(no, inventory);
        return updatedInventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<Void> deleteInventoryItem(@PathVariable Long no) {
        if (inventoryService.deleteInventoryItem(no)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


    /*
    @Autowired
    public InventoryController(InventoryService inventoryService, ItemService itemService) {
        this.inventoryService = inventoryService;
        this.itemService = itemService;
    }

    @GetMapping
    public List<InventoryTable> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{itemCode}")
    public InventoryTable getItemByCode(@PathVariable("itemCode") Long itemCode) {
        return inventoryService.getInventoryByCode(itemCode);
    }

    @GetMapping("/items")
    public List<ItemTable> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    public ResponseEntity<InventoryTable> createInventory(@RequestBody InventoryTable inventory) {
        Optional<ItemTable> itemOptional = itemService.findItemByCode(inventory.getItemCode());
        if (itemOptional.isPresent()) {
            ItemTable item = itemOptional.get();
            inventory.setItemName(item.getItemName());
            inventory.setItemQty(item.getItemQty());
            inventory.setStockQty(item.getItemQty() - inventory.getStockOut());
            InventoryTable savedInventory = inventoryService.createInventory(inventory);
            return ResponseEntity.ok(savedInventory);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{itemCode}")
    public ResponseEntity<InventoryTable> updateInventory(@PathVariable("itemCode") Long itemCode, @RequestBody InventoryTable inventory) {
        Optional<ItemTable> itemOptional = itemService.findItemByCode(itemCode);
        if (itemOptional.isPresent()) {
            ItemTable item = itemOptional.get();
            inventory.setItemName(item.getItemName());
            inventory.setItemQty(item.getItemQty());
            inventory.setStockQty(item.getItemQty() - inventory.getStockOut());
            InventoryTable updatedInventory = inventoryService.updateInventory(itemCode, inventory);
            return ResponseEntity.ok(updatedInventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{itemCode}")
    public ResponseEntity<Void> deleteInventory(@PathVariable("itemCode") Long itemCode) {
        try {
            inventoryService.deleteInventory(itemCode);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
*/
