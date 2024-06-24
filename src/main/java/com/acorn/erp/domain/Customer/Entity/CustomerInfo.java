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

@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerInfo {
	public CustomerInfo() {}
	public CustomerInfo(int customer_id, String customer_name, String customer_gender, Date customer_birth_date,
			String customer_addr, String customer_tel, Date register_date) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_gender = customer_gender;
		this.customer_birth_date = customer_birth_date;
		this.customer_addr = customer_addr;
		this.customer_tel = customer_tel;
		this.register_date = register_date;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_info_seq")
    @SequenceGenerator(name = "customer_info_seq", sequenceName = "customer_info_seq", allocationSize = 1)
	private int customer_id;
	private String customer_name;
	private String customer_gender;
	private Date customer_birth_date;
	private String customer_addr;
	private String customer_tel;
	private Date register_date;
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_gender() {
		return customer_gender;
	}
	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}
	public Date getCustomer_birth_date() {
		return customer_birth_date;
	}
	public void setCustomer_birth_date(Date customer_birth_date) {
		this.customer_birth_date = customer_birth_date;
	}
	public String getCustomer_addr() {
		return customer_addr;
	}
	public void setCustomer_addr(String customer_addr) {
		this.customer_addr = customer_addr;
	}
	public String getCustomer_tel() {
		return customer_tel;
	}
	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "Customer_info [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_gender="
				+ customer_gender + ", customer_birth_date=" + customer_birth_date + ", customer_addr=" + customer_addr
				+ ", customer_tel=" + customer_tel + ", register_date=" + register_date + "]";
	}
	
}
