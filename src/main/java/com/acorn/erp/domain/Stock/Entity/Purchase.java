package com.acorn.erp.domain.Stock.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Purchase {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long purchaseCode;

    @Column(name = "purchase_unit")
    private String purchaseUnit;

    @Column(name = "purchase_name", length = 21)
    private String purchaseName;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "order_qty")
    private Long orderQty;

    @Column(name = "price")
    private Long price;

    @Column(name = "remark", length = 300)
    private String remark;

}
