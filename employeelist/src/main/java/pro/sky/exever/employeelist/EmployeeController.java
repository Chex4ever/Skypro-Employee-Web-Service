package pro.sky.exever.employeelist;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	private static final Logger log = Logger.getLogger("pro.sky.exever.employeelist.EmployeeController");
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/add")
	public Employee addEmployee(@RequestParam(required = false, name = "firstName") String firstName,
			@RequestParam(required = false, name = "lastName") String lastName) {
		checkArgs(firstName, lastName);
		return employeeService.addEmployee(firstName, lastName);
	}

	@GetMapping("/remove")
	public Employee removeEmployee(@RequestParam(required = false, name = "firstName") String firstName,
			@RequestParam(required = false, name = "lastName") String lastName) {
		checkArgs(firstName, lastName);
		return employeeService.removeEmployee(firstName, lastName);
	}

	@GetMapping("/find")
	public Employee findEmployee(@RequestParam(required = false, name = "firstName") String firstName,
			@RequestParam(required = false, name = "lastName") String lastName) {
		checkArgs(firstName, lastName);
		return employeeService.findEmployee(firstName, lastName);
	}

	@GetMapping("/all")
	public Collection<Employee> showAllEmployees() {
		return employeeService.showAllEmployees();
	}

	public static Boolean checkArgs(String firstName, String lastName) {
		if (firstName == null || firstName.length() < 1) {
			throw new IllegalArgumentException("Имя не задано (firstName)");
		}
		if (lastName == null || lastName.length() < 1) {
			throw new IllegalArgumentException("Фамилия не задана (lastName)");
		}
		return true;
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	public String handleException(RuntimeException e) {
		log.severe(e.getMessage());
		return (e.getMessage());
	}
}
