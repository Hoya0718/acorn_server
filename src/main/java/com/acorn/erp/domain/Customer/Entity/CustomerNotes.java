package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;
import lombok.Data;

@Data
public class CustomerNotes {
	private String notes_id;
	private String customer_id;
	private Date notes_date;
	private String notes;
	
	public CustomerNotes() {}

	@Override
	public String toString() {
		return "Customer_notes [notes_id=" + notes_id + ", customer_id=" + customer_id + ", notes_date=" + notes_date
				+ ", notes=" + notes + "]";
	}

	
}
