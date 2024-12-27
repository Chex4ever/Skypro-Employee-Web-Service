package pro.sky.exever.employeewebservice;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
	int salaryMax(int DepartmentId);
	int salaryMin(int DepartmentId);
	int salarySum(int departmentId);
	Map<Integer, List<Employee>> allEmployeesByDepartment();
	Collection<Employee> employeesFromDepartment (int DepartmentId);
}
