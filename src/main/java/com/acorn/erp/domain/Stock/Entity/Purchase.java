package com.acorn.erp.domain.Stock.Purchase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDto {
	private String purchaseCode;
	private String purchaseName;
	private String purchaseUnit;
	private String orderDate;
	private int orderQuantity;
	private long unitPrice;
	private String purchaseRemark;
	
}
