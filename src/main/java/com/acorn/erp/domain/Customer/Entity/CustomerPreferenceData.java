package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_PREFERENCE_DATA")
public class CustomerPreferenceData {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_preference_data_seq")
    @SequenceGenerator(name = "customer_preference_data_seq", sequenceName = "customer_preference_data_seq", allocationSize = 1)
	private int preference_data_id;
	private String product_name; //FK 변수명확인
	private int total_amount_for_product;
	private int total_count_for_product;
	private double rating ;
	private String gender_preference;
	private String age_preference; 
	private String region_preference; 
	
	public CustomerPreferenceData() {}

	@Override
	public String toString() {
		return "Customer_preference_data [preference_data_id=" + preference_data_id + ", product_name=" + product_name
				+ ", total_amount_for_product=" + total_amount_for_product + ", total_count_for_product="
				+ total_count_for_product + ", rating=" + rating + ", gender_preference=" + gender_preference
				+ ", age_preference=" + age_preference + ", region_preference=" + region_preference + "]";
	}

	public CustomerPreferenceData(int preference_data_id, String product_name, int total_amount_for_product,
			int total_count_for_product, double rating, String gender_preference, String age_preference,
			String region_preference) {
		super();
		this.preference_data_id = preference_data_id;
		this.product_name = product_name;
		this.total_amount_for_product = total_amount_for_product;
		this.total_count_for_product = total_count_for_product;
		this.rating = rating;
		this.gender_preference = gender_preference;
		this.age_preference = age_preference;
		this.region_preference = region_preference;
	}

	


	
}
