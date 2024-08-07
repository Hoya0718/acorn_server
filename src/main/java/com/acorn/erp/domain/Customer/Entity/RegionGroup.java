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
@Table(name = "REGION_GROUP",
uniqueConstraints = {@UniqueConstraint(columnNames = {"customerId", "regiongroupProvince"})}
)
public class RegionGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_group_seq")
    @SequenceGenerator(name = "region_group_seq", sequenceName = "region_group_seq", allocationSize = 1)
	private int regiongroupId;
	@Column(nullable = false)
	private int customerId;
	private String regiongroupProvince;
	private String regiongroupCity;
	private String regiongroupTown;
	
	public int getRegiongroupId() {
		return regiongroupId;
	}

	public void setRegiongroupId(int regiongroupId) {
		this.regiongroupId = regiongroupId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getRegiongroupProvince() {
		return regiongroupProvince;
	}

	public void setRegiongroupProvince(String regiongroupProvince) {
		this.regiongroupProvince = regiongroupProvince;
	}

	public String getRegiongroupCity() {
		return regiongroupCity;
	}

	public void setRegiongroupCity(String regiongroupCity) {
		this.regiongroupCity = regiongroupCity;
	}

	public String getRegiongroupTown() {
		return regiongroupTown;
	}

	public void setRegiongroupTown(String regiongroupTown) {
		this.regiongroupTown = regiongroupTown;
	}

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
