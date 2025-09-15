package pack1;

public class Customer {
BankServer server;
	
public Customer(BankServer server)
{
	this.server=server;
}


	public String  requestForLoan(int creditScore)
	{
		/*if(creditScore>=500)
		{
			return "Eligible for Loan".toUpperCase();
		}
		return "NOT eligible".toUpperCase();*/
		
	 return server.check(creditScore).toUpperCase();	
	}
}

