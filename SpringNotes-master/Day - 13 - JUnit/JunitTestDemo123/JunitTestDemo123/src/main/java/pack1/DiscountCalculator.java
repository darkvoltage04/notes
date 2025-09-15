package pack1;

public class DiscountCalculator {

	public static  double calculateDiscount(double price, double discoutpercentage)
	{
		if(price<=0 || discoutpercentage<0 || discoutpercentage>100)
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		return price-(price*discoutpercentage/100);
	}
	
	
}
