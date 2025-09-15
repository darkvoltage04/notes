package test.pack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pack1.TestHelper;

public class TestHelperJunit {
	static TestHelper helper=null;
	//@BeforeEach
	@BeforeAll
	public  static void setUp()
	{
	 helper=new TestHelper();
		System.out.println("helper object initialized");
	}
	@Test
	public void testMethodForValidCondition()
	{
		boolean expected=true;
		boolean actual=helper.checkFirstAndLastStringEuqal("ABCD");
		assertEquals(expected, actual);
		System.out.println("This test case one");
	}
	
	@Test
	public void testMethodForInvalidCondition()
	{
		assertFalse(helper.checkFirstAndLastStringEuqal("A"));
		System.out.println("This test case two");
	}
	
	//@AfterEach
	@AfterAll
	public static  void tearDown()
	{
		helper=null;
		System.out.println("deinitailized helper object");
	}
	
	
	
	
	
	
	
	
	
	
	

}
