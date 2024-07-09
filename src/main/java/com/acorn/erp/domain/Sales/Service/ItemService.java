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
        item.calculateStockQty(); // 재고 합계 계산
        return itemRepository.save(item);
    }

    public ItemTable updateItem(Long itemCode, ItemTable newItem) {
        ItemTable itemtbl = getItemByCode(itemCode);
        itemtbl.setItemType(newItem.getItemType());
        itemtbl.setItemName(newItem.getItemName());
        itemtbl.setItemStatus(newItem.getItemStatus());
        itemtbl.setItemPrice(newItem.getItemPrice());
        itemtbl.setItemQty(newItem.getItemQty());
        itemtbl.setStockOut(newItem.getStockOut());
        itemtbl.calculateStockQty(); // 재고 합계 계산
        return itemRepository.save(itemtbl);
    }

    @Transactional
    public void deleteItem(Long itemCode) {
        ItemTable item = getItemByCode(itemCode);
        itemRepository.delete(item);
    }
}
