package pro.sky.exever.employeelist;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	
    public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping("/add")
    public Employee addEmployee(@RequestParam (required = false, name = "firstName") String firstName,
    		@RequestParam (required = false, name = "lastName") String lastName) {
		checkArgs(firstName, lastName);
		return employeeService.addEmployee(firstName, lastName);
	}

	@GetMapping("/remove")
    public Employee removeEmployee(@RequestParam (required = false, name = "firstName") String firstName,
    		@RequestParam (required = false, name = "lastName") String lastName) {
		checkArgs(firstName, lastName);
		return employeeService.removeEmployee(firstName, lastName);
	}

	@GetMapping("/find")
	public Employee findEmployee(@RequestParam (required = false, name = "firstName") String firstName,
			@RequestParam (required = false, name = "lastName") String lastName) {
		checkArgs(firstName, lastName);
		return employeeService.findEmployee(firstName, lastName);
	}
	
	public static Boolean checkArgs(String firstName, String lastName) {
		if (firstName == null || firstName.length()<1) {
			throw new IllegalArgumentException("Имя не задано (firstName=null)");
		}
		if (lastName == null || lastName.length()<1) {
			throw new IllegalArgumentException("Фамилия не задана (lastName=null)");
		}
		return true;
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<String> handleException(EmployeeAlreadyAddedException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
	}
}
