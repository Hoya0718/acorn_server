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
@Table(name = "AGE_GROUP",
uniqueConstraints = {@UniqueConstraint(columnNames = {"customerId", "ageGroup"})}
)
public class AgeGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "age_group_seq")
    @SequenceGenerator(name = "age_group_seq", sequenceName = "age_group_seq", allocationSize = 1)
	private int agegroupId;
	@Column(nullable = false)
	private int customerId;
	private String ageGroup;
	
	public int getAgegroupId() {
		return agegroupId;
	}

	public void setAgegroupId(int agegroupId) {
		this.agegroupId = agegroupId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public AgeGroup() {}

	@Override
	public String toString() {
		return "AgeGroup [agegroupId=" + agegroupId + ", customerId=" + customerId + ", ageGroup=" + ageGroup + "]";
	}

	public AgeGroup(int agegroupId, int customerId, String ageGroup) {
		super();
		this.agegroupId = agegroupId;
		this.customerId = customerId;
		this.ageGroup = ageGroup;
	}



}
