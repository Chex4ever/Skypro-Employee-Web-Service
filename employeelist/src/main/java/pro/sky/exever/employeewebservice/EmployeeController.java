package pro.sky.exever.employeewebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/add")
	public Employee addEmployee(@RequestParam String firstName, String lastName, int salary, int departmentId) {
		return employeeService.addEmployee(firstName, lastName, salary, departmentId);
	}

	@GetMapping("/remove")
	public Employee removeEmployee(@RequestParam String firstName, String lastName) {
		return employeeService.removeEmployee(firstName, lastName);
	}

	@GetMapping("/find")
	public Employee findEmployee(@RequestParam String firstName, String lastName) {
		return employeeService.findEmployee(firstName, lastName);
	}

	@GetMapping("/all")
	public Collection<Employee> showAllEmployees() {
		return employeeService.allEmployees();
	}

}
