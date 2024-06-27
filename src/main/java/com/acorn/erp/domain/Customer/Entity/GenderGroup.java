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
		name = "Gender_GROUP",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"customerId", "genderGroup"})}
		)
public class GenderGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_group_seq")
    @SequenceGenerator(name = "gender_group_seq", sequenceName = "gender_group_seq", allocationSize = 1)
	private int agegroupId;
	@Column(nullable = false)
	private int customerId;
	private String genderGroup;
	
	
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

	public String getGenderGroup() {
		return genderGroup;
	}

	public void setGenderGroup(String genderGroup) {
		this.genderGroup = genderGroup;
	}

	public GenderGroup() {}

	@Override
	public String toString() {
		return "GenderGroup [agegroupId=" + agegroupId + ", customerId=" + customerId + ", genderGroup=" + genderGroup
				+ "]";
	}

	public GenderGroup(int agegroupId, int customerId, String genderGroup) {
		super();
		this.agegroupId = agegroupId;
		this.customerId = customerId;
		this.genderGroup = genderGroup;
	}




}
