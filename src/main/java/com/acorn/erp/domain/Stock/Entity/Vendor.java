package com.acorn.erp.domain.Stock.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @Column(name = "vendor_code", nullable = false)
    private Long vendorCode;

    @Column(name = "vendor_name", length = 9)
    private String vendorName;

    @Column(name = "vendor_p", length = 11)
    private String vendorContact;

    @Column(name = "vendor_addr", length = 90)
    private String vendorAddress;

    @Column(name = "remark", length = 300)
    private String vendorRemark;

    @Column(name = "deliverable_status")
    private boolean deliverableStatus;


}
