package com.acorn.erp.domain.Customer.Entity;

import lombok.Data;

@Data
public class Regiongroup {
	private String regiongroup_id;
	private String customer_id;
	private String regiongroup_province;
	private String regiongroup_city;
	private String regiongroup_town;
	
	public Regiongroup() {}

	@Override
	public String toString() {
		return "regiongroup [regiongroup_id=" + regiongroup_id + ", customer_id=" + customer_id
				+ ", regiongroup_province=" + regiongroup_province + ", regiongroup_city=" + regiongroup_city
				+ ", regiongroup_town=" + regiongroup_town + "]";
	}


}
