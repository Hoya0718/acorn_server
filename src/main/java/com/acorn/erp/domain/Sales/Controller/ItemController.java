package com.acorn.erp.domain.Sales.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.acorn.erp.domain.Sales.Entity.ItemTable;
import com.acorn.erp.domain.Sales.Service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemTable> getAllItems() {
        return itemService.getAllItems();
    }

    // 異붽???遺遺?
    @GetMapping("/paged")
    public Page<ItemTable> getItems(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "7") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("itemCode").descending());
        return itemService.getItems(pageable);
    }

    @GetMapping("/{itemCode}")
    public ItemTable getItemByCode(@PathVariable("itemCode") Long itemCode) {
        return itemService.getItemByCode(itemCode);
    }

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody ItemTable item) {
        try {
            ItemTable createdItem = itemService.createItem(item);
            return ResponseEntity.ok(createdItem);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{itemCode}")
    public ItemTable updateItem(@PathVariable("itemCode") Long itemCode, @RequestBody ItemTable item) {
        return itemService.updateItem(itemCode, item);
    }

    @DeleteMapping("/{itemCode}")
    public ResponseEntity<Void> deleteItem(@PathVariable("itemCode") Long itemCode) {
        try {
            itemService.deleteItem(itemCode);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    //?ш퀬 ?⑷퀎
    @PostMapping("/save")
    public ResponseEntity<ItemTable> saveItem(@RequestBody ItemTable item) {
    	ItemTable savedItem = itemService.saveItem(item);
        return ResponseEntity.ok(savedItem);
    }
    

}
