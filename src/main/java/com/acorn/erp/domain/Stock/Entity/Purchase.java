package com.acorn.erp.domain.Stock.Entity;

import java.time.LocalDateTime;

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
public class Purchase {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "item_code", unique = true, length = 10)
    private String itemCode;

    @Column(name = "purchase_unit")
    private String purchaseUnit;

    @Column(name = "purchase_name", length = 21)
    private String purchaseName;

    @Column(name = "order_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String orderDate;

    @Column(name = "order_qty")
    private Integer orderQty;

    @Column(name = "price")
    private Long price;

    @Column(name = "remark", length = 300)
    private String remark;


}