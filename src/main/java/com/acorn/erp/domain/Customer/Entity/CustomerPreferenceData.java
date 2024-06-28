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

	public int getPreferenceDataId() {
		return preferenceDataId;
	}

	public void setPreferenceDataId(int preferenceDataId) {
		this.preferenceDataId = preferenceDataId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getTotalAmountForProduct() {
		return totalAmountForProduct;
	}

	public void setTotalAmountForProduct(int totalAmountForProduct) {
		this.totalAmountForProduct = totalAmountForProduct;
	}

	public int getTotalCountForProduct() {
		return totalCountForProduct;
	}

	public void setTotalCountForProduct(int totalCountForProduct) {
		this.totalCountForProduct = totalCountForProduct;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getGenderPreference() {
		return genderPreference;
	}

	public void setGenderPreference(String genderPreference) {
		this.genderPreference = genderPreference;
	}

	public String getAgePreference() {
		return agePreference;
	}

	public void setAgePreference(String agePreference) {
		this.agePreference = agePreference;
	}

	public String getRegionPreference() {
		return regionPreference;
	}

	public void setRegionPreference(String regionPreference) {
		this.regionPreference = regionPreference;
	}

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
