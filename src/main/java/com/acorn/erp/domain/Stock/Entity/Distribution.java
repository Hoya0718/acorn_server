package com.acorn.erp.domain.Stock.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Distribution {
	@Id
    @GeneratedValue
    private Long id;

//    @Column(name = "item_code", unique = true, length = 10)
//    private String itemCode;
//
//    @Column(name = "item_name", length = 20)
//    private String itemName;

    @Column(name = "receipt_date")
    private String receiptDate;

    @Column(name = "initial_qty")
    private Integer initialQty;

    @Column(name = "received_qty")
    private Integer receivedQty;

    @Column(name = "release_qty")
    private Integer releaseQty;

    @Column(name = "current_qty", length = 300)
    private Integer currentQty;
    
    @Column(name = "expected_recepit_date", length = 30)
    private String expectedReceiptDate;
    
    
    
}
