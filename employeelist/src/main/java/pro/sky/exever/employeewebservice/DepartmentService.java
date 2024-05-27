package pro.sky.exever.employeewebservice;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
	public Employee maxSalary(int DepartmentId);
	public Employee minSalary(int DepartmentId);
	public Map<Integer, List<Employee>> allEmployeesByDepartment();
	public List<Employee> employeesFromDepartment (int DepartmentId);
}
