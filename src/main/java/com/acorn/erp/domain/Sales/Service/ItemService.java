package com.acorn.erp.domain.Sales.Service;

import java.util.List;

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
    	ItemTable existingItem = getItemByCode(itemCode);
        existingItem.setItemType(newItem.getItemType());
        existingItem.setItemName(newItem.getItemName());
        existingItem.setItemStatus(newItem.getItemStatus());
        existingItem.setItemPrice(newItem.getItemPrice());
        existingItem.setItemQty(newItem.getItemQty());
        return itemRepository.save(existingItem);
    }

    @Transactional
    public void deleteItem(Long itemCode) {
    	ItemTable item = getItemByCode(itemCode);
        itemRepository.delete(item);
    }
}
