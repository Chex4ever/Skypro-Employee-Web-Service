package pro.sky.exever.employeelist;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private List<Employee> employees = new ArrayList<>();
	private int maxEmployeesCount = 2;

	public Employee addEmployee(String firstName, String lastName) {
		if (this.employees.size() >= maxEmployeesCount) {
			throw new EmployeeStorageIsFullException();
		}
		for (Employee employee : employees) {
			if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
				throw new EmployeeAlreadyAddedException();
			}
		}
		Employee employee = new Employee(firstName, lastName);
		employees.add(employee);
		System.out.println("Добавлен сотрудник"+employee.toString());
		return employee;

	}

	public Employee removeEmployee(String firstName, String lastName) {
		System.out.println("Удаляю сотрудника "+firstName+" "+lastName);
		Employee employee = findEmployee(firstName, lastName);
		employees.remove(employee);
		return employee;
	}

	public Employee findEmployee(String firstName, String lastName) {
		System.out.println("Ищу сотрудника "+firstName+" "+lastName);
		for (Employee employee : employees) {
			if (employee.getFirstName().contains(firstName) && employee.getLastName().contains(lastName)) {
				return employee;
			}
		}
		System.err.println("Сотрудника "+firstName+" "+lastName+" не найден"); //EmployeeNotFoundException
		if (true) {
		throw new EmployeeNotFoundException();
		}
		return new Employee(firstName, lastName);
	}

}
