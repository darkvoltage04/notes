package test.pack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import pack1.Employee;
import pack1.EmployeeRepo;
import pack1.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class TestEmp {
	
	@Mock
	private EmployeeRepo repos;	
	
	@InjectMocks
	private EmployeeService service;
	
	private Employee emp=null;
	@BeforeEach
	public void setUp()
	{
		 emp=new Employee(108, "ABC", "abc@gmail.com",45999.00);
		
		//MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testAddEmployee()
	{
		
		
		when(repos.addEmployeeToList(emp)).thenReturn(1);
		int result=service.addEmployee(emp);
		assertEquals(1, result);
		verify(repos,times(1)).addEmployeeToList(emp);
	}
	
	@Test
	public void testForDelete()
	{
		Employee emp=new Employee(108, "ABC", "abc@gmail.com",45999.00);
        doNothing().when(repos).deleteEmployeeFromList(emp);
		   service.deleteEmployee(emp);
		   verify(repos, times(1)).deleteEmployeeFromList(emp);
	}
	
	public void testForFetchEmp()
	{
		Employee emp=new Employee(108, "ABC", "abc@gmail.com",45999.00);
		when(repos.getEmployeeByEmployeeId(108)).thenReturn(emp);
	Employee e=	 service.fetchEmployeeById(108);
		assertNotNull(e);
		verify(repos, times(2)).getEmployeeByEmployeeId(108);
		
	}
	
	
	
	

}
