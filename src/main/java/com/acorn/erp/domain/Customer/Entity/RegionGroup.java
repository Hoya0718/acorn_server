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
	private int regiongroupId;
	private int customerId;
	private String regiongroupProvince;
	private String regiongroupCity;
	private String regiongroupTown;
	
	public RegionGroup() {}

	@Override
	public String toString() {
		return "RegionGroup [regiongroupId=" + regiongroupId + ", customerId=" + customerId + ", regiongroupProvince="
				+ regiongroupProvince + ", regiongroupCity=" + regiongroupCity + ", regiongroupTown=" + regiongroupTown
				+ "]";
	}

	public RegionGroup(int regiongroupId, int customerId, String regiongroupProvince, String regiongroupCity,
			String regiongroupTown) {
		super();
		this.regiongroupId = regiongroupId;
		this.customerId = customerId;
		this.regiongroupProvince = regiongroupProvince;
		this.regiongroupCity = regiongroupCity;
		this.regiongroupTown = regiongroupTown;
	}



}
