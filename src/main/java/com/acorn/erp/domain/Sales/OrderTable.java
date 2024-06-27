package com.acorn.erp.domain.Sales;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		name = "ORDER_TABLE")
public class OrderTable {
	public OrderTable() {}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_num")
    @SequenceGenerator(name = "order_num", sequenceName = "order_num", allocationSize = 1)
	private int orderNum;
	private String itemCode;
	private String itemName;
	private int customerId;
	private String customerName;
	private String customerTel;
	private String customerAddr;
	private int price;
	private int itemQty;
	private int deliveryFee;
	private int totalPrice;
	private Date orderDate;
	private String itemReq;
	private String orderStatus;
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public int getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getItemReq() {
		return itemReq;
	}
	public void setItemReq(String itemReq) {
		this.itemReq = itemReq;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderNum=" + orderNum + ", itemCode=" + itemCode + ", itemName=" + itemName + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", customerTel=" + customerTel + ", customerAddr=" + customerAddr + ", price=" + price
				+ ", itemQty=" + itemQty + ", deliveryFee=" + deliveryFee + ", totalPrice=" + totalPrice
				+ ", orderDate=" + orderDate + ", itemReq=" + itemReq + ", orderStatus=" + orderStatus + "]";
	}
	public OrderTable(int orderNum, String itemCode, String itemName, int customerId, String customerName, String customerTel,
			String csAddr, int price, int itemQty, int deliveryFee, int totalPrice, Date orderDate, String itemReq,
			String orderStatus) {
		super();
		this.orderNum = orderNum;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerTel = customerTel;
		this.customerAddr = customerAddr;
		this.price = price;
		this.itemQty = itemQty;
		this.deliveryFee = deliveryFee;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.itemReq = itemReq;
		this.orderStatus = orderStatus;
	}
}
