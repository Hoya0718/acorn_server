package com.acorn.erp.domain.Sales.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "SALES_ORDER")
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_order_SEQ")
    @SequenceGenerator(name = "sales_order_SEQ", sequenceName = "sales_order_SEQ", allocationSize = 1)
    private Long orderNum;

    @Column(name = "item_name", length = 30, nullable = false)
    private String itemName;

    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "customer_id",  length = 20)
    private Integer customerId;
    
    @Column(name = "customer_tel", length = 13)
    private String customerTel;

    @Column(name = "customer_addr", length = 90)
    private String customerAddr;

    @Column(name = "order_price")
    private BigDecimal orderPrice;

    @Column(name = "item_qty")
    private Integer itemQty;

    @Column(name = "delivery_fee")
    private BigDecimal deliveryFee;

    @Column(name = "order_total_price")
    private BigDecimal orderTotalPrice;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "order_req", length = 300)
    private String orderReq;

    @Column(name = "order_status", length = 10)
    private String orderStatus;
    
    
	public Long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Integer getItemQty() {
		return itemQty;
	}
	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}
	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public BigDecimal getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderReq() {
		return orderReq;
	}
	public void setOrderReq(String orderReq) {
		this.orderReq = orderReq;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	// 기본 생성자 추가
    public OrderTable() {}
	public OrderTable(Integer customerId, Long orderNum, String itemName, String customerName, String customerTel, String customerAddr,
			BigDecimal orderPrice, Integer itemQty, BigDecimal deliveryFee, BigDecimal orderTotalPrice,
			LocalDateTime orderDate, String orderReq, String orderStatus) {
		super();
		this.customerId = customerId;
		this.orderNum = orderNum;
		this.itemName = itemName;
		this.customerName = customerName;
		this.customerTel = customerTel;
		this.customerAddr = customerAddr;
		this.orderPrice = orderPrice;
		this.itemQty = itemQty;
		this.deliveryFee = deliveryFee;
		this.orderTotalPrice = orderTotalPrice;
		this.orderDate = orderDate;
		this.orderReq = orderReq;
		this.orderStatus = orderStatus;
	}
	
    // orderTotalPrice를 계산하는 메서드 추가
    public void calculateTotalPrice() {
        if (orderPrice != null && itemQty > 0) {
            this.orderTotalPrice = orderPrice.multiply(BigDecimal.valueOf(itemQty));
        }
    }
}