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
public class Materials {
@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "materials_code", unique = true, length = 10)
    private String materialsCode;

    @Column(name = "materials_name", length = 20)
    private String materialsName;
    
    @Column(name = "receipt_date")
    private String receiptDate;

    //@Column(name = "price")
    //private Long price;
    
    @Column(name = "quantity")
    private Integer quantity;

//    @Column(name = "vendor_Code")
//    private String vendorCode;

}