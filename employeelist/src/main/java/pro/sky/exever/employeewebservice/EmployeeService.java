package pro.sky.exever.employeewebservice;

import java.util.Collection;

public interface EmployeeService {
	public Employee add(String lastName, String firstName, int salary, int departmentId);
	public Employee remove(String lastName, String firstName);
	public Employee find(String lastName, String firstName);
	public Collection<Employee> all();
}
