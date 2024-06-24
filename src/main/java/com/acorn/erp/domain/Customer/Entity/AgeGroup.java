package com.acorn.erp.domain.Customer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "AGE_GROUP")
public class AgeGroup {
	@Id
	private String agegroup_id;
	private String customer_id;
	private String ageGroup;
	
	public AgeGroup() {}

	@Override
	public String toString() {
		return "ageroup [agegroup_id=" + agegroup_id + ", customer_id=" + customer_id + ", agegroup=" + ageGroup + "]";
	}



}
