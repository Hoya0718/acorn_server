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
@Table(name = "CUSTOMER_NOTES")
public class CustomerNotes {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_notes_seq")
    @SequenceGenerator(name = "customer_notes_seq", sequenceName = "customer_notes_seq", allocationSize = 1)
	private int notes_id;
	private int customer_id;
	private Date notes_date;
	private String notes;
	
	public CustomerNotes() {}

	@Override
	public String toString() {
		return "Customer_notes [notes_id=" + notes_id + ", customer_id=" + customer_id + ", notes_date=" + notes_date
				+ ", notes=" + notes + "]";
	}

	public CustomerNotes(int notes_id, int customer_id, Date notes_date, String notes) {
		super();
		this.notes_id = notes_id;
		this.customer_id = customer_id;
		this.notes_date = notes_date;
		this.notes = notes;
	}

	
}
