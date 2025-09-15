package test.pack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pack1.Associate;
import pack1.InvalidAssociate;

public class TestAssociate {

	Associate a=null;
	@BeforeEach
	public void setUp()
	{
		a=new Associate();
	}
	@Test
	@DisplayName("valid Associates")
	public void testForValidCondition() throws InvalidAssociate
	{
Associate obj=a.getAssociate("Gopal", 42, "kolkata");
assertNotNull(obj);
		
	}
	
	@Test
	public void testForInvalidCondition()
	{
InvalidAssociate exception=		
assertThrows(InvalidAssociate.class, ()->a.getAssociate("abcd", 10, "abc"));
	assertEquals("not valid Associate",exception.getMessage());
	
	}
	
	
	
}
