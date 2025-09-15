package pack1;
import java.util.List;

public class EmployeeService {
    private EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public int addEmployee(Employee e) {
        return repo.addEmployeeToList(e);
    }

    public void deleteEmployee(Employee e) {
        repo.deleteEmployeeFromList(e);
    }

    public Employee fetchEmployeeById(int empId) {
        Employee e = repo.getEmployeeByEmployeeId(empId);
        if (e == null) {
            throw new NullPointerException("Employee Not Found");
        }
        return e;
    }

    public List<Employee> fetchEmployee() {
        List<Employee> list = repo.getEmployee();
        if (list.isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        return list;
    }
}
