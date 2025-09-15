package test.pack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import pack1.DiscountCalculator;

public class TestDiscountCalcultor {
	
	
	@ParameterizedTest
	@CsvSource({
		"100,10,9",
		"200,20,160"
	})
	
	
	public void testCalculateDiscount(double price, double per, double expected)
	{
		  double actual=DiscountCalculator.calculateDiscount(price, per);
		  assertEquals(expected, actual);
	}

}
