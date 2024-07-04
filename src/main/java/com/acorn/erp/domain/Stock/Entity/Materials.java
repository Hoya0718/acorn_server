package com.acorn.erp.domain.Stock.Entity;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Materials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_code", unique = true, length = 10)
    private String itemCode;

    @Column(name = "item_name", length = 20)
    private String itemName;

    @Column(name = "receipt_date")
    private String receiptDate;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "vendor_code")
    private String vendorCode;
}