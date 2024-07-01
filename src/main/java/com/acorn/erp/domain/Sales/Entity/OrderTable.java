package com.acorn.erp.domain.Sales.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_table_SEQ")
    @Column(name = "order_num", nullable = false)
    @SequenceGenerator(name = "order_table_SEQ", sequenceName = "order_table_SEQ", allocationSize = 1)
    private Long orderNum;

    @Column(name = "item_name", length = 30, nullable = false)
    private String itemName;

    //@ManyToOne
    @JoinColumn(name = "customer_name")
    private String customerName;
    
    @Column(name = "customer_id", nullable = false, length = 20)
    private int customerId;
    
    @Column(name = "customer_tel", length = 11)
    private String customerTel;

    @Column(name = "customer_addr", length = 90)
    private String customerAddr;

    @Column(name = "order_price")
    private BigDecimal orderPrice;

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
    
    

}