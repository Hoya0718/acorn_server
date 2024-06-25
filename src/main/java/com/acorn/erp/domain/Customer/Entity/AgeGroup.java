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
@Table(name = "AGE_GROUP")
public class AgeGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "age_group_seq")
    @SequenceGenerator(name = "age_group_seq", sequenceName = "age_group_seq", allocationSize = 1)
	private int agegroupId;
	private int customerId;
	private String ageGroup;
	
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
