package test.pack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import pack1.Employee;
import pack1.EmployeeRepo;
import pack1.EmployeeService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class EmployeeTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.openMocks(this);
        employee = new Employee(101, "John Doe", "john@example.com", 45000);
    }

    @Test
    public void test1AddEmployee() {
        when(employeeRepo.addEmployeeToList(employee)).thenReturn(1);
        int result = employeeService.addEmployee(employee);
        assertEquals(1, result);
    }

    @Test
    public void test2DeleteEmployee() {
        employeeService.deleteEmployee(employee);
        verify(employeeRepo, times(1)).deleteEmployeeFromList(employee);
    }

    @Test
    public void test3FetchEmployeeByEmployeeId() {
        when(employeeRepo.getEmployeeByEmployeeId(101)).thenReturn(employee);
        Employee result = employeeService.fetchEmployeeById(101);
        assertNotNull(result);
        assertEquals("John Doe", result.getEmployeeName());
    }

    @Test
    public void test4FetchEmployeeByEmployeeIdWhenNull() {
        when(employeeRepo.getEmployeeByEmployeeId(999)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            employeeService.fetchEmployeeById(999);
        });
    }

    @Test
    public void test5FetchEmployee() {
        when(employeeRepo.getEmployee()).thenReturn(Arrays.asList(employee));
        List<Employee> result = employeeService.fetchEmployee();
        assertEquals(1, result.size());
    }
}
