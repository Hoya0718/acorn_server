package com.acorn.erp.domain.Sales.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public Page<ItemTable> getItems(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    public ItemTable getItemByCode(Long itemCode) {
        return itemRepository.findById(itemCode).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public ItemTable createItem(ItemTable item) {
        return itemRepository.save(item);
    }

    public ItemTable updateItem(Long itemCode, ItemTable item) {
        ItemTable existingItem = itemRepository.findById(itemCode).orElseThrow(() -> new RuntimeException("Item not found"));
        
        existingItem.setItemType(item.getItemType());
        existingItem.setItemStatus(item.getItemStatus());
        existingItem.setItemName(item.getItemName());
        existingItem.setItemQty(item.getItemQty());
        existingItem.setItemPrice(item.getItemPrice());
        existingItem.setStockOut(item.getStockOut());
        existingItem.setStockQty(item.getStockQty());

        // ?먮ℓ ?곹깭媛 "?덉젅"?????섎웾??0?쇰줈 ?ㅼ젙
        if ("?덉젅".equals(item.getItemStatus())) {
            existingItem.setItemQty(0);
            existingItem.setStockOut(0);
            existingItem.setStockQty(0);
        }

        return itemRepository.save(existingItem);
    }

    public void deleteItem(Long itemCode) {
        itemRepository.deleteById(itemCode);
    }
    
    public ItemTable saveItem(ItemTable item) {
        item.calculateStockQty(); // ?ш퀬?⑷퀎瑜?怨꾩궛
        return itemRepository.save(item); // DB?????
    }
    

}
