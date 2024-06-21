package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;
import lombok.Data;

@Data
public class CustomerInfo {
	private String customer_id;
	private String customer_name;
	private String customer_gender;
	private Date customer_birth_date;
	private String customer_addr;
	private String customer_tel;
	private Date register_date;
	
	public CustomerInfo() {}
	@Override
	public String toString() {
		return "Customer_info [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_gender="
				+ customer_gender + ", customer_birth_date=" + customer_birth_date + ", customer_addr=" + customer_addr
				+ ", customer_tel=" + customer_tel + ", register_date=" + register_date + "]";
	}
	
}
