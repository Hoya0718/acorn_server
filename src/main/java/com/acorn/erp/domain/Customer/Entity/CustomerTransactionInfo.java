package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_TRANSACTION_INFO")
public class CustomerTransactionInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_transaction_data_seq")
    @SequenceGenerator(name = "customer_transaction_data_seq", sequenceName = "customer_transaction_data_seq", allocationSize = 1)
	private int transaction_info_id;
	private int customer_id;
	private Date last_transaction_date;
	private int total_amount_for_customer;
	private String top_selling_product; //FK 변수명확인
	private  int total_count_for_customer;
	private String most_purchased_product; //FK 변수명확인
	
	public CustomerTransactionInfo() {}

	@Override
	public String toString() {
		return "Customer_transaction_info [transaction_info_id=" + transaction_info_id + ", customer_id=" + customer_id
				+ ", last_transaction_date=" + last_transaction_date + ", total_amount_for_customer="
				+ total_amount_for_customer + ", top_selling_product=" + top_selling_product
				+ ", total_transaction_count=" + total_count_for_customer + ", most_purchased_product="
				+ most_purchased_product + "]";
	}

	public CustomerTransactionInfo(int transaction_info_id, int customer_id, Date last_transaction_date,
			int total_amount_for_customer, String top_selling_product, int total_count_for_customer,
			String most_purchased_product) {
		super();
		this.transaction_info_id = transaction_info_id;
		this.customer_id = customer_id;
		this.last_transaction_date = last_transaction_date;
		this.total_amount_for_customer = total_amount_for_customer;
		this.top_selling_product = top_selling_product;
		this.total_count_for_customer = total_count_for_customer;
		this.most_purchased_product = most_purchased_product;
	}


	
}
