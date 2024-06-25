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
	private int agegroup_id;
	private int customer_id;
	private String ageGroup;
	
	public AgeGroup() {}

	@Override
	public String toString() {
		return "ageroup [agegroup_id=" + agegroup_id + ", customer_id=" + customer_id + ", agegroup=" + ageGroup + "]";
	}

	public AgeGroup(int agegroup_id, int customer_id, String ageGroup) {
		super();
		this.agegroup_id = agegroup_id;
		this.customer_id = customer_id;
		this.ageGroup = ageGroup;
	}



}
