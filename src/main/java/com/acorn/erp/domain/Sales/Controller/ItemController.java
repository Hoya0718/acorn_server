package com.acorn.erp.domain.Sales.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.acorn.erp.domain.Sales.Entity.Item;
import com.acorn.erp.domain.Sales.Service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{itemCode}")
    public Item getItemByCode(@PathVariable("itemCode") Long itemCode) {
        return itemService.getItemByCode(itemCode);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
       return itemService.createItem(item);
   }

    @PutMapping("/{itemCode}")
    public Item updateItem(@PathVariable("itemCode") Long itemCode, @RequestBody Item item) {
        return itemService.updateItem(itemCode, item);
    }

    @DeleteMapping("/{itemCode}")
    public ResponseEntity<Void> deleteItem(@PathVariable("itemCode") Long itemCode) {
        try {
            itemService.deleteItem(itemCode);
            return ResponseEntity.noContent().build(); // 성공적으로 삭제되었음을 나타내는 응답 반환
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build(); // itemCode에 해당하는 항목이 없을 경우 404 Not Found 반환
       }
   }
}
