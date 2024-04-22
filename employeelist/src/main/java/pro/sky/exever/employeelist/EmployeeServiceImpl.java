package pro.sky.exever.employeelist;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private List<Employee> employees= new ArrayList<>();
	private int maxEmployeesCount = 16384;
	
	public Employee addEmployee(String firstName, String lastName) {
		if (this.employees.size()>= maxEmployeesCount) {
			throw new EmployeeStorageIsFullException();
		}
		for (Employee employee : employees) {
			if (employee.getName().equals(firstName) && employee.getName().equals(lastName)) {
				throw new EmployeeAlreadyAddedException();
			}
		};
		Employee employee=new Employee(firstName, lastName);
		employees.add(employee);
		return employee;
		
	}
	public Employee removeEmployee(String firstName, String lastName) {
		Employee employee=findEmployee(firstName, lastName);
		employees.remove(employee);
		return employee;
	}
	public Employee findEmployee(String firstName, String lastName) {
		for (Employee employee : employees) {
			if (employee.getName().contains(firstName) && employee.getName().contains(lastName)) {
				return employee;
			}
		};
		throw new EmployeeNotFoundException();
	}
	
	
}
