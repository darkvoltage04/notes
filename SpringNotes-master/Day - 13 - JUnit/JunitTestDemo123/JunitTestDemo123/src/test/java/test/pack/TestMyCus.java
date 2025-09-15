package test.pack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pack1.BankServer;
import pack1.Customer;

public class TestMyCus {

	Customer cust=null;
	
	BankServer ser=new BankServer() {
		
		@Override
		public String check(int score) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	@BeforeEach
	public void setUp()
	{
		cust=new Customer(ser);
	}
	
	@Test
	public void testValidCustomer()
	{
	String msg=	cust.requestForLoan(500);
	assertEquals("ELIGIBLE FOR LOAN", msg);
	}
}
