package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;
import lombok.Data;

@Data
public class Customer_transaction_info {
	private String transaction_info_id;
	private String customer_id;
	private Date last_transaction_date;
	private Number total_amount_for_customer;
	private String top_selling_product; //FK 변수명확인
	private  Number total_count_for_customer;
	private String most_purchased_product; //FK 변수명확인
	
	public Customer_transaction_info() {}

	@Override
	public String toString() {
		return "Customer_transaction_info [transaction_info_id=" + transaction_info_id + ", customer_id=" + customer_id
				+ ", last_transaction_date=" + last_transaction_date + ", total_amount_for_customer="
				+ total_amount_for_customer + ", top_selling_product=" + top_selling_product
				+ ", total_transaction_count=" + total_count_for_customer + ", most_purchased_product="
				+ most_purchased_product + "]";
	}


	
}
