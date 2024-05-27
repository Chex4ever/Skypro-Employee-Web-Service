package pro.sky.exever.employeewebservice;

import java.util.Collection;

public interface EmployeeService {
	public Employee addEmployee(String firstName, String lastName, int salary, int departmentId);
	public Employee removeEmployee(String firstName, String lastName);
	public Employee findEmployee(String firstName, String lastName);
	public Collection<Employee> allEmployees();
}
