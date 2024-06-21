package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;
import lombok.Data;

@Data
public class CustomerGrade {
	private String grade_id;
	private String customer_id;
	private String customer_grade;
	
	public CustomerGrade() {}

	@Override
	public String toString() {
		return "Customer_grade [grade_id=" + grade_id + ", customer_id=" + customer_id + ", customer_grade="
				+ customer_grade + "]";
	}



	
}
