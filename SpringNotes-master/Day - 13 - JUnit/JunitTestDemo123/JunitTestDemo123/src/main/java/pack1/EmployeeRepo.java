package pack1;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    private List<Employee> empList = new ArrayList<>();

    public int addEmployeeToList(Employee e) {
        empList.add(e);
        return empList.size();
    }

    public void deleteEmployeeFromList(Employee e) {
        empList.remove(e);
    }

    public Employee getEmployeeByEmployeeId(int empId) {
        for (Employee e : empList) {
            if (e.getEmployeeId() == empId) {
                return e;
            }
        }
        return null;
    }

    public List<Employee> getEmployee() {
        return empList;
    }
}
