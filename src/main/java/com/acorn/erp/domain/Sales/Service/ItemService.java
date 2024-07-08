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
