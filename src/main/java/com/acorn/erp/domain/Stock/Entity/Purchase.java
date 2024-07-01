package com.acorn.erp.domain.Stock.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Purchase {

	// 코드
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long purchaseCode;

	// 발주 단위
    @Column(name = "purchase_unit")
    private String purchaseUnit;

    // 발주 단위
    @Column(name = "purchase_name", length = 21)
    private String purchaseName;
    
    // 발주 일자
    @Column(name = "order_date")
    private String orderDate;
    
    // 발주 수량
    @Column(name = "order_qty")
    private Long orderQty;

    // 원가
    @Column(name = "price")
    private Long price;

    // 특이사항
    @Column(name = "remark", length = 300)
    private String remark;
    
    // 입고 일자
    @Column(name = "receipt_date")
    private String receiptDate;

    // 입고 수량
    @Column(name = "initial_qty")
    private Integer initialQty;

    // 기초 재고
    @Column(name = "received_qty")
    private Integer receivedQty;

    // 출고 수량
    @Column(name = "release_qty")
    private Integer releaseQty;

    // 집계 재고
    @Column(name = "current_qty", length = 300)
    private Integer currentQty;
    
    // 입고예정일
    @Column(name = "expected_recepit_date", length = 30)
    private String expectedReceiptDate;
    
    
    

}
