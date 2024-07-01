package com.acorn.erp.domain.Customer.Entity;

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
@Table(
		name = "CUSTOMER_GRADE",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"customerId", "customerGrade"})}
		)
public class CustomerGrade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_grade_seq")
    @SequenceGenerator(name = "customer_grade_seq", sequenceName = "customer_grade_seq", allocationSize = 1)
	private int gradeId;
	@Column(nullable = false)
	private int customerId;
	private String customerGrade = "일반";
	
	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public CustomerGrade() {}

	@Override
	public String toString() {
		return "CustomerGrade [gradeId=" + gradeId + ", customerId=" + customerId + ", customerGrade=" + customerGrade
				+ "]";
	}

	public CustomerGrade(int customerId) {
		this.customerId = customerId;
		this.customerGrade = "일반";
	}

	
}
