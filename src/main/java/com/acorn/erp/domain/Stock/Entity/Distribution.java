package com.acorn.erp.domain.Stock.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Distribution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "distribution_code", unique = true) 
    private String distributionCode;

    @Column(name = "distribution_unit")
    private String distributionUnit;

    @Column(name = "receipt_date")
    private String receiptDate;
    
    @Column(name = "order_qty")
    private Integer orderQty;

    @Column(name = "initial_qty")
    private Integer initialQty;

    @Column(name = "received_qty")
    private Integer receivedQty;

    @Column(name = "release_qty")
    private Integer releaseQty;

    @Column(name = "current_qty")
    private Integer currentQty;

    @Column(name = "expected_receipt_date")
    private String expectedReceiptDate;

}
