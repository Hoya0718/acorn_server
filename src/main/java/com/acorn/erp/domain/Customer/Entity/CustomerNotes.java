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
	private int notesId;
	private int customerId;
	private Date notesDate;
	private String notes;
	
	public CustomerNotes() {}

	@Override
	public String toString() {
		return "CustomerNotes [notesId=" + notesId + ", customerId=" + customerId + ", notesDate=" + notesDate
				+ ", notes=" + notes + "]";
	}

	public CustomerNotes(int notesId, int customerId, Date notesDate, String notes) {
		super();
		this.notesId = notesId;
		this.customerId = customerId;
		this.notesDate = notesDate;
		this.notes = notes;
	}


}
