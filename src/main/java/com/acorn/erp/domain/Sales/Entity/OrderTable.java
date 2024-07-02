package com.acorn.erp.domain.Sales.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class OrderTable {
	private ItemTable itemTable;
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_table_SEQ")
    @Column(name = "order_num", nullable = false)
    @SequenceGenerator(name = "order_table_SEQ", sequenceName = "order_table_SEQ", allocationSize = 1)
    private Long orderNum;

    @Column(name = "item_name", length = 30, nullable = false)
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "customer_name")
    private String customerName;
    
    @Column(name = "customer_id", nullable = false, length = 20)
    private int customerId;
    
    @Column(name = "customer_tel", length = 11)
    private String customerTel;

    @Column(name = "customer_addr", length = 90)
    private String customerAddr;

    @Column(name = "order_price")
    private BigDecimal orderPrice = BigDecimal.ZERO;

    @Column(name = "item_qty")
    private int itemQty;

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


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
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


	public int getItemQty() {
		return itemQty;
	}


	public void setItemQty(int itemQty) {
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


	public OrderTable(int customerId, Long orderNum, String itemName, String customerName, String customerTel, String customerAddr,
			BigDecimal orderPrice, int itemQty, BigDecimal deliveryFee, BigDecimal orderTotalPrice,
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

	// 기본 생성자 추가
    public OrderTable() {
    }
}