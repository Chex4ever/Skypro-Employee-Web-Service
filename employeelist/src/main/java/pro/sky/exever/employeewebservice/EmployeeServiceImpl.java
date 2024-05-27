package pro.sky.exever.employeewebservice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

import pro.sky.exever.employeewebservice.exception.EmployeeAlreadyAddedException;
import pro.sky.exever.employeewebservice.exception.EmployeeNotFoundException;
import pro.sky.exever.employeewebservice.exception.EmployeeStorageIsFullException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private Map<String, Employee> employees = new HashMap<>();
	private int maxEmployeesCount = 10;
	private static final Logger LOG = Logger.getLogger("pro.sky.exever.employeelist.EmployeeService");

	public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {
		String key = makeKey(firstName, lastName);
		if (this.employees.size() >= maxEmployeesCount) {
			throw new EmployeeStorageIsFullException();
		}
		if (this.employees.containsKey(key)) {
			throw new EmployeeAlreadyAddedException();
		}
		Employee employee = new Employee(firstName, lastName, salary, departmentId);
		employees.put(key, employee);
		LOG.info("Добавлен сотрудник" + employee.toString() + ", ключ " + key);
		return employee;
	}

	public Employee removeEmployee(String firstName, String lastName) {
		LOG.info("Удаляю сотрудника " + firstName + " " + lastName);
		Employee employee = findEmployee(firstName, lastName);
		return employees.remove(employee.toString());
	}

	public Collection<Employee> allEmployees() {
		LOG.info("Список всех сотрудников");
		return employees.values();
	}

	public Employee findEmployee(String firstName, String lastName) {
		LOG.info("Ищу сотрудника " + firstName + " " + lastName);
		String key = makeKey(firstName, lastName);
		if (!employees.containsKey(key)) {
			throw new EmployeeNotFoundException();
		}
		return employees.get(key);
	}

	private String makeKey(String firstName, String lastName) {
		return firstName + " " + lastName;
	}
}
