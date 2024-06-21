package com.acorn.erp.domain.Stock.Vendor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorDto {
    private String vendorCode;
    private String vendorName;
    private String vendorContact;
    private String vendorAddress;
    private String vendorRemark;
    private boolean deliverableStatus;
}
