package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
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
	private Date lastTransactionDate;
	private int totalAmountForCustomer;
	private String topSellingProduct; //FK 변수명확인
	private  int totalCountForCustomer;
	private String mostPurchasedProduct; //FK 변수명확인
	
	public CustomerTransactionInfo() {}

	@Override
	public String toString() {
		return "CustomerTransactionInfo [transactionInfoId=" + transactionInfoId + ", customerId=" + customerId
				+ ", lastTransactionDate=" + lastTransactionDate + ", totalAmountForCustomer=" + totalAmountForCustomer
				+ ", topSellingProduct=" + topSellingProduct + ", totalCountForCustomer=" + totalCountForCustomer
				+ ", mostPurchasedProduct=" + mostPurchasedProduct + "]";
	}

	public CustomerTransactionInfo(int transactionInfoId, int customerId, Date lastTransactionDate,
			int totalAmountForCustomer, String topSellingProduct, int totalCountForCustomer,
			String mostPurchasedProduct) {
		super();
		this.transactionInfoId = transactionInfoId;
		this.customerId = customerId;
		this.lastTransactionDate = lastTransactionDate;
		this.totalAmountForCustomer = totalAmountForCustomer;
		this.topSellingProduct = topSellingProduct;
		this.totalCountForCustomer = totalCountForCustomer;
		this.mostPurchasedProduct = mostPurchasedProduct;
	}



	
}
