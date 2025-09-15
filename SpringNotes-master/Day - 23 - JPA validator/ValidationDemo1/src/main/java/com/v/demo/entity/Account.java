package com.v.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Account_Table")
public class Account {
	
	
	@SequenceGenerator(name = "acn_gen", initialValue = 8000, allocationSize = 4)
	@GeneratedValue(generator = "acn_gen", strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name="acn_no", updatable = false)
	private long accountNumber;
	@Column(name="acn_type", nullable = false)
	private String accountType;
	@Column(name="pin_code",nullable = false)
	private int pinCode;
	@Column(name="cust_id", nullable = false)
	private int customerId;
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
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
	
	

}
