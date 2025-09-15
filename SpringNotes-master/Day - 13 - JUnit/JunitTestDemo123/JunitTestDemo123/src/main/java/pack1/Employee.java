package pack1;
public class Employee {
    private int employeeId;
    private String employeeName;
    private String email;
    private double salary;

    public Employee(int employeeId, String employeeName, String email, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
