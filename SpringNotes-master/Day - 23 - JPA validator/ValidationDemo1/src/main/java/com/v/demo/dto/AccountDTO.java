package com.v.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountDTO {
	
	@NotBlank(message = "Account type is required")
	@Pattern(regexp = "[A-Z]+", message = "The account type should be in upper case")
	//@Email
	
	
	private String accountType;
	
	@Min(value = 1000, message = "pin code must be atleast 4 digit")
	@Max(value=9999, message = "pin code must be atleast 4 digit")
	private int pinCode;

	@Positive(message = "customer id must positive integer")
	private int customerId;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/*@Past
	@PastOrPresent
	@Future
	@FutureOrPresent*/
	
	
	

}
