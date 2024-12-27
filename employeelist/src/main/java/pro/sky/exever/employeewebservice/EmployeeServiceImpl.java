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
	private final ValidationService validationService;

	public EmployeeServiceImpl(ValidationService validationService) {
		this.validationService = validationService;
	}

	@Override
	public Employee add(String lastName, String firstName, int salary, int departmentId) {
		lastName = validationService.validateName(lastName);
		firstName = validationService.validateName(firstName);
		String key = makeKey(lastName, firstName);
		if (this.employees.size() >= maxEmployeesCount) {
			LOG.warning("База переполнена, сотрудник не добавлен");
			throw new EmployeeStorageIsFullException();
		}
		if (this.employees.containsKey(key)) {
			LOG.warning("Сотрудник %s %s уже есть в базе, сотрудник не добавлен".formatted(lastName, firstName));
			throw new EmployeeAlreadyAddedException("%s %s".formatted(lastName, firstName));
		}

		Employee employee = new Employee(lastName, firstName, salary, departmentId);
		employees.put(key, employee);
		LOG.info("Добавлен сотрудник %s".formatted(key));
		return employee;
	}

	@Override
	public Employee remove(String lastName, String firstName) {
		lastName = validationService.validateName(lastName);
		firstName = validationService.validateName(firstName);
		LOG.info("Удаляю сотрудника " + lastName + " " + firstName);
		Employee employee = find(lastName, firstName);
		return employees.remove(employee.toString());
	}

	@Override
	public Collection<Employee> all() {
		LOG.info("Список всех сотрудников");
		return employees.values();
	}

	@Override
	public Employee find(String lastName, String firstName) {
		lastName = validationService.validateName(lastName);
		firstName = validationService.validateName(firstName);
		LOG.info("Ищу сотрудника " + lastName + " " + firstName);
		String key = makeKey(lastName, firstName);
		if (!employees.containsKey(key)) {
			throw new EmployeeNotFoundException("%s %s".formatted(lastName, firstName));
		}
		return employees.get(key);
	}

	private String makeKey(String lastName, String firstName) {
		return lastName + " " + firstName;
	}

}
