package com.acorn.erp.domain.Sales.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SALES_ITEM")
public class Item {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "item_code", nullable = false)
    private Long itemCode;
    
    @Column(name = "item_type", length = 10)
    private String itemType;

    @Column(name = "item_name", length = 30)
    private String itemName;

    @Column(name = "item_status", length = 30)
    private String itemStatus;

    @Column(name = "item_price")
    private int itemPrice;

    @Column(name = "item_qty")
    private int itemQty;
    
    // 생성자
    public Item() {}
	public Item(Long itemCode, String itemType, String itemName, String itemStatus, int itemPrice,
			int itemQty) {
		super();
		this.itemCode = itemCode;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemStatus = itemStatus;
		this.itemPrice = itemPrice;
		this.itemQty = itemQty;
	}
	
	public Long getItemCode() {
		return itemCode;
	}
	public void setItemCode(Long itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	
}