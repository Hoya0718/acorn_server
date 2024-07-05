package com.acorn.erp.domain.Sales.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Sales.Entity.InventoryTable;
import com.acorn.erp.domain.Sales.Entity.ItemTable;
import com.acorn.erp.domain.Sales.Service.InventoryService;
import com.acorn.erp.domain.Sales.Service.ItemService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    private final ItemService itemService;

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
            return ResponseEntity.noContent().build(); // 성공적으로 삭제되었음을 나타내는 응답 반환
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // itemCode에 해당하는 항목이 없을 경우 404 Not Found 반환
        }
    }
}