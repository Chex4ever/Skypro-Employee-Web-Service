package pro.sky.exever.employeelist;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private List<Employee> employees = new ArrayList<>();
	private int maxEmployeesCount = 2;
	private static final Logger log = Logger.getLogger("pro.sky.exever.employeelist.EmployeeService");

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
		log.info("Добавлен сотрудник"+employee.toString());
		return employee;

	}

	public Employee removeEmployee(String firstName, String lastName) {
		log.info("Удаляю сотрудника "+firstName+" "+lastName);
		Employee employee = findEmployee(firstName, lastName);
		employees.remove(employee);
		return employee;
	}
	
	public List<Employee> showAllEmployees() {
		log.info("Список всех сотрудников");
		return employees;
	}
	
	public Employee findEmployee(String firstName, String lastName) {
		log.info("Ищу сотрудника "+firstName+" "+lastName);
		for (Employee employee : employees) {
			if (employee.getFirstName().contains(firstName) && employee.getLastName().contains(lastName)) {
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}

}
