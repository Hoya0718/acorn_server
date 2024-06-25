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
	private int grade_id;
	private int customer_id;
	private String customer_grade;
	
	public CustomerGrade() {}

	@Override
	public String toString() {
		return "Customer_grade [grade_id=" + grade_id + ", customer_id=" + customer_id + ", customer_grade="
				+ customer_grade + "]";
	}

	public CustomerGrade(int grade_id, int customer_id, String customer_grade) {
		super();
		this.grade_id = grade_id;
		this.customer_id = customer_id;
		this.customer_grade = customer_grade;
	}



	
}
