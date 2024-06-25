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
@Table(name = "REGION_GROUP")
public class RegionGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_group_seq")
    @SequenceGenerator(name = "region_group_seq", sequenceName = "region_group_seq", allocationSize = 1)
	private int regiongroup_id;
	private int customer_id;
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

	public RegionGroup(int regiongroup_id, int customer_id, String regiongroup_province, String regiongroup_city,
			String regiongroup_town) {
		super();
		this.regiongroup_id = regiongroup_id;
		this.customer_id = customer_id;
		this.regiongroup_province = regiongroup_province;
		this.regiongroup_city = regiongroup_city;
		this.regiongroup_town = regiongroup_town;
	}


}
