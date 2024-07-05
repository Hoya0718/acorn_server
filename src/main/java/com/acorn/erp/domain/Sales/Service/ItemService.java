
package com.acorn.erp.domain.Sales.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Sales.Entity.ItemTable;
import com.acorn.erp.domain.Sales.Repository.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemTable> getAllItems() {
        return itemRepository.findAll();
    }

    public ItemTable getItemByCode(Long itemCode) {
        return itemRepository.findById(itemCode)
                .orElseThrow(() -> new RuntimeException("Item not found with code: " + itemCode));
    }

    public ItemTable createItem(ItemTable item) {
        return itemRepository.save(item);
    }

    public ItemTable updateItem(Long itemCode, ItemTable newItem) {
        ItemTable itemtbl = getItemByCode(itemCode);
        itemtbl.setItemType(newItem.getItemType());
        itemtbl.setItemName(newItem.getItemName());
        itemtbl.setItemStatus(newItem.getItemStatus());
        itemtbl.setItemPrice(newItem.getItemPrice());
        itemtbl.setItemQty(newItem.getItemQty());
        return itemRepository.save(itemtbl);
    }

    @Transactional
    public void deleteItem(Long itemCode) {
        ItemTable item = getItemByCode(itemCode);
        itemRepository.delete(item);
    }
    
    public Optional<ItemTable> findItemByCode(Long itemCode) {
        return itemRepository.findById(itemCode);
    }

}

//package com.acorn.erp.domain.Sales.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.acorn.erp.domain.Sales.Entity.Item;
//import com.acorn.erp.domain.Sales.Repository.ItemRepository;
//
//@Service
//public class ItemService {
//    private final ItemRepository itemRepository;
//
//    @Autowired
//    public ItemService(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }
//
//    public List<Item> getAllItems() {
//        return itemRepository.findAll();
//    }
//
//    public Item getItemByCode(Long itemCode) {
//        return itemRepository.findById(itemCode)
//                .orElseThrow(() -> new RuntimeException("Item not found with code: " + itemCode));
//    }
//
//    public Item createItem(Item item) {
//        return itemRepository.save(item);
//    }
//
//    public Item updateItem(Long itemCode, Item newItem) {
//        Item existingItem = getItemByCode(itemCode);
//        existingItem.setItemType(newItem.getItemType());
//        existingItem.setItemName(newItem.getItemName());
//        existingItem.setItemStatus(newItem.getItemStatus());
//        existingItem.setItemPrice(newItem.getItemPrice());
//        existingItem.setItemQty(newItem.getItemQty());
//        return itemRepository.save(existingItem);
//    }
//
//    @Transactional
//    public void deleteItem(Long itemCode) {
//        Item item = getItemByCode(itemCode);
//        itemRepository.delete(item);
//    }
//}
