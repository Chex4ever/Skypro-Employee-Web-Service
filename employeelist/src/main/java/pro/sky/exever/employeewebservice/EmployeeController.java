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
	public Employee add(@RequestParam String lastName, String firstName, int salary, int departmentId) {
		return employeeService.add(lastName, firstName, salary, departmentId);
	}

	@GetMapping("/remove")
	public Employee remove(@RequestParam String lastName, String firstName) {
		return employeeService.remove(lastName, firstName);
	}

	@GetMapping("/find")
	public Employee find(@RequestParam String lastName, String firstName) {
		return employeeService.find(lastName, firstName);
	}

	@GetMapping("/all")
	public Collection<Employee> all() {
		return employeeService.all();
	}

}
