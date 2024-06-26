package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;

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
@Table(name = "CUSTOMER_NOTES",
uniqueConstraints = {@UniqueConstraint(columnNames = {"customerId", "notes"})}
)
public class CustomerNotes {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_notes_seq")
    @SequenceGenerator(name = "customer_notes_seq", sequenceName = "customer_notes_seq", allocationSize = 1)
	private int notesId;
	@Column(nullable = false)
	private int customerId;
	private Date notesDate;
	private String notes;
	
	public int getNotesId() {
		return notesId;
	}

	public void setNotesId(int notesId) {
		this.notesId = notesId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getNotesDate() {
		return notesDate;
	}

	public void setNotesDate(Date notesDate) {
		this.notesDate = notesDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

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
