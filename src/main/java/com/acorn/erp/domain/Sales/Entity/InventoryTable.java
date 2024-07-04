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
@Table(name = "SALES_INVENTORY")
public class InventoryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long no;
    
    @Column(name = "item_code")
    private Long itemCode;

    @Column(name = "item_name", length = 30)
    private String itemName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "item_code", referencedColumnName = "item_code", insertable = false, updatable = false)
//    private ItemTable itemTable;

    @Column(name = "stock_in")
    private int stockIn = 0;

    @Column(name = "stock_out")
    private int stockOut = 0;

    @Column(name = "stock_qty")
    private int stockQty = 0;
    
    // 기본 생성자
    public InventoryTable() {}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getItemCode() {
		return itemCode;
	}
	public void setItemCode(Long itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getStockIn() {
		return stockIn;
	}
	public void setStockIn(int stockIn) {
		this.stockIn = stockIn;
	}
	public int getStockOut() {
		return stockOut;
	}
	public void setStockOut(int stockOut) {
		this.stockOut = stockOut;
	}
	public int getStockQty() {
		return stockQty;
	}
	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}
    
}