package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;
import lombok.Data;

@Data
public class CustomerPreferenceData {
	private String preference_data_id;
	private String product_name; //FK 변수명확인
	private int total_amount_for_product;
	private  int total_count_for_product;
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

	


	
}
