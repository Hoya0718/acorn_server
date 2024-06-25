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
@Table(name = "CUSTOMER_GRADE")
public class CustomerGrade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_grade_seq")
    @SequenceGenerator(name = "customer_grade_seq", sequenceName = "customer_grade_seq", allocationSize = 1)
	private int gradeId;
	private int customerId;
	private String customerGrade;
	
	public CustomerGrade() {}

	@Override
	public String toString() {
		return "CustomerGrade [gradeId=" + gradeId + ", customerId=" + customerId + ", customerGrade=" + customerGrade
				+ "]";
	}

	public CustomerGrade(int gradeId, int customerId, String customerGrade) {
		super();
		this.gradeId = gradeId;
		this.customerId = customerId;
		this.customerGrade = customerGrade;
	}

	
}
