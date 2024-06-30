package com.acorn.erp.domain.Customer.Entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


@Entity
@Table(name = "CUSTOMER_TRANSACTION_INFO",
uniqueConstraints = {@UniqueConstraint(columnNames = {"customerId", "transactionInfoId"})}
)
public class CustomerTransactionInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_transaction_data_seq")
    @SequenceGenerator(name = "customer_transaction_data_seq", sequenceName = "customer_transaction_data_seq", allocationSize = 1)
	private int transactionInfoId;
	@Column(nullable = false)
	private int customerId;
	private String customerName;
	private Date lastTransactionDate;
	private int totalAmountForCustomer;
	private String topSellingProduct; //FK 변수명확인: itemName
	private  int totalCountForCustomer;
	private String mostPurchasedProduct; //FK 변수명확인: itemName
	
	public int getTransactionInfoId() {
		return transactionInfoId;
	}

	public void setTransactionInfoId(int transactionInfoId) {
		this.transactionInfoId = transactionInfoId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getLastTransactionDate() {
		return lastTransactionDate;
	}

	public void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

	public int getTotalAmountForCustomer() {
		return totalAmountForCustomer;
	}

	public void setTotalAmountForCustomer(int totalAmountForCustomer) {
		this.totalAmountForCustomer = totalAmountForCustomer;
	}

	public String getTopSellingProduct() {
		return topSellingProduct;
	}

	public void setTopSellingProduct(String topSellingProduct) {
		this.topSellingProduct = topSellingProduct;
	}

	public int getTotalCountForCustomer() {
		return totalCountForCustomer;
	}

	public void setTotalCountForCustomer(int totalCountForCustomer) {
		this.totalCountForCustomer = totalCountForCustomer;
	}

	public String getMostPurchasedProduct() {
		return mostPurchasedProduct;
	}

	public void setMostPurchasedProduct(String mostPurchasedProduct) {
		this.mostPurchasedProduct = mostPurchasedProduct;
	}

	public CustomerTransactionInfo() {}

	@Override
	public String toString() {
		return "CustomerTransactionInfo [transactionInfoId=" + transactionInfoId + ", customerId=" + customerId
				+ ", cutomerName=" + customerName + ", lastTransactionDate=" + lastTransactionDate
				+ ", totalAmountForCustomer=" + totalAmountForCustomer + ", topSellingProduct=" + topSellingProduct
				+ ", totalCountForCustomer=" + totalCountForCustomer + ", mostPurchasedProduct=" + mostPurchasedProduct
				+ "]";
	}

	public CustomerTransactionInfo(int transactionInfoId, int customerId, String customerName, Date lastTransactionDate,
			int totalAmountForCustomer, String topSellingProduct, int totalCountForCustomer,
			String mostPurchasedProduct) {
		super();
		this.transactionInfoId = transactionInfoId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.lastTransactionDate = lastTransactionDate;
		this.totalAmountForCustomer = totalAmountForCustomer;
		this.topSellingProduct = topSellingProduct;
		this.totalCountForCustomer = totalCountForCustomer;
		this.mostPurchasedProduct = mostPurchasedProduct;
	}

	


	
}
