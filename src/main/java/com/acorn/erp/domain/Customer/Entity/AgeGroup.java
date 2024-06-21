package com.acorn.erp.domain.Customer.Entity;

import lombok.Data;

@Data
public class AgeGroup {
	private String agegroup_id;
	private String customer_id;
	private String agegroup;
	
	public AgeGroup() {}

	@Override
	public String toString() {
		return "ageroup [agegroup_id=" + agegroup_id + ", customer_id=" + customer_id + ", agegroup=" + agegroup + "]";
	}



}
