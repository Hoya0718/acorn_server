package com.acorn.erp.domain.Customer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Gender_GROUP")
public class GenderGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_group_seq")
    @SequenceGenerator(name = "gender_group_seq", sequenceName = "gender_group_seq", allocationSize = 1)
	private int agegroupId;
	private int customerId;
	private String genderGroup;
	
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
