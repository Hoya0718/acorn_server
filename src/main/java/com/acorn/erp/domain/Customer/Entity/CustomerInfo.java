package com.acorn.erp.domain.Customer.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerInfo {
	public CustomerInfo() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_info_seq")
    @SequenceGenerator(name = "customer_info_seq", sequenceName = "customer_info_seq", allocationSize = 1)
	private Integer customerId;
    @Column(name = "customer_name", length = 30, nullable = false)
	private String customerName;
	private String customerGender;
	private Date customerBirthDate;
	private String customerAddr;
	private String customerTel;
	private Date registerDate;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public Date getCustomerBirthDate() {
		return customerBirthDate;
	}
	public void setCustomerBirthDate(Date customerBirthDate) {
		this.customerBirthDate = customerBirthDate;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", customerName=" + customerName + ", customerGender="
				+ customerGender + ", customerBirthDate=" + customerBirthDate + ", customerAddr=" + customerAddr
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
