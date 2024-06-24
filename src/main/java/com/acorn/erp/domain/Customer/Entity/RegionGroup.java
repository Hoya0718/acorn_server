package com.acorn.erp.domain.Customer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "REGION_GROUP")
public class RegionGroup {
	@Id
	private String regiongroup_id;
	private String customer_id;
	private String regiongroup_province;
	private String regiongroup_city;
	private String regiongroup_town;
	
	public RegionGroup() {}

	@Override
	public String toString() {
		return "regiongroup [regiongroup_id=" + regiongroup_id + ", customer_id=" + customer_id
				+ ", regiongroup_province=" + regiongroup_province + ", regiongroup_city=" + regiongroup_city
				+ ", regiongroup_town=" + regiongroup_town + "]";
	}


}
