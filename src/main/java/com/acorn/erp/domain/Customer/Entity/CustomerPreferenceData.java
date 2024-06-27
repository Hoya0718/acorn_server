package com.acorn.erp.domain.Customer.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_PREFERENCE_DATA")
public class CustomerPreferenceData {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_preference_data_seq")
    @SequenceGenerator(name = "customer_preference_data_seq", sequenceName = "customer_preference_data_seq", allocationSize = 1)
	private int preferenceDataId;
	private String itemName; //FK 변수명확인
	private int totalAmountForProduct;
	private int totalCountForProduct;
	private double rating ;
	private String genderPreference;
	private String agePreference; 
	private String regionPreference; 
	
	public CustomerPreferenceData() {}

	@Override
	public String toString() {
		return "CustomerPreferenceData [preferenceDataId=" + preferenceDataId + ", productName=" + itemName
				+ ", totalAmountForProduct=" + totalAmountForProduct + ", totalCountForProduct=" + totalCountForProduct
				+ ", rating=" + rating + ", genderPreference=" + genderPreference + ", agePreference=" + agePreference
				+ ", regionPreference=" + regionPreference + "]";
	}

	public CustomerPreferenceData(int preferenceDataId, String productName, int totalAmountForProduct,
			int totalCountForProduct, double rating, String genderPreference, String agePreference,
			String regionPreference) {
		super();
		this.preferenceDataId = preferenceDataId;
		this.itemName = productName;
		this.totalAmountForProduct = totalAmountForProduct;
		this.totalCountForProduct = totalCountForProduct;
		this.rating = rating;
		this.genderPreference = genderPreference;
		this.agePreference = agePreference;
		this.regionPreference = regionPreference;
	}

	
}
