package com.acorn.erp.domain.Login.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class userInfo {
	private Long id;
	private String email;
	private String password;
	private String shopName;
	private String registrationNum;
}