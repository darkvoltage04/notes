package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * @Component is class level annotation
 * @Component annotation is used to instantiate  or creating object for 
 * class
 * If class decorated with @Component annotation then Spring IoC container
 * scan that class and creates the object for that class
 * 
 * the default name of the object is the class name but first character 
 * of the class name will b decapitalized that means if the Customer then
 * the bean name will customer
 * 
 * we can also provide our own bean name
 * 
 * 
 * 
 * 
 */
@Component
@Scope(value = "prototype")
public class Customer {
	
	@Value("108")
	private long customerId;

	private String customerName;
	@Value("abc@gmail.com")
	private String customerEmail;
	@Value("1334")
	private long customerPhone;
	
	@Autowired
	private Address address;//=new Address()
	
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	@Value("ABC")
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhone=" + customerPhone + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
