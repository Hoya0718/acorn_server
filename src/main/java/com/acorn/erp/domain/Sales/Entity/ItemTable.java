package com.acorn.erp.domain.Sales.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SALES_ITEM")
public class ItemTable {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    
    @Column(name = "stock_out")
    private Integer  stockOut;

    @Column(name = "stock_qty")
    private Integer  stockQty;
    
    // ?앹꽦??
    public ItemTable() {}
	public ItemTable(Long itemCode, String itemType, String itemName, String itemStatus, int itemPrice, int itemQty,
			Integer stockOut, Integer stockQty) {
		super();
		this.itemCode = itemCode;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemStatus = itemStatus;
		this.itemPrice = itemPrice;
		this.itemQty = itemQty;
		this.stockOut = stockOut;
		this.stockQty = stockQty;
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
	public Integer getStockOut() {
		return stockOut;
	}
	public void setStockOut(Integer stockOut) {
		this.stockOut = stockOut;
	}
	public Integer getStockQty() {
		return stockQty;
	}
	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}
	
    // ?ш퀬?⑷퀎瑜?怨꾩궛?섎뒗 硫붿꽌??
    public void calculateStockQty() {
        this.stockQty = this.itemQty - this.stockOut;
    }
}
