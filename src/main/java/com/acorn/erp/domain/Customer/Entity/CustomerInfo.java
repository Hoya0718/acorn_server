package com.acorn.erp.domain.Customer.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerInfo {
	public CustomerInfo() {}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_info_seq")
    @SequenceGenerator(name = "customer_info_seq", sequenceName = "customer_info_seq", allocationSize = 1)
	private int customerId;
	private String customerName;
	private String customerGender;
	private Date customerBirthDate;
	private String customerAddr;
	private String customerTel;
	private Date registerDate;
	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", customerName=" + customerName + ", customerGender="
				+ customerGender + ", customer_birthDate=" + customerBirthDate + ", customerAddr=" + customerAddr
				+ ", customerTel=" + customerTel + ", registerDate=" + registerDate + "]";
	}
	public CustomerInfo(int customerId, String customerName, String customerGender, Date customer_birthDate,
			String customerAddr, String customerTel, Date registerDate) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerBirthDate = customerBirthDate;
		this.customerAddr = customerAddr;
		this.customerTel = customerTel;
		this.registerDate = registerDate;
	}
	
	
	
}
