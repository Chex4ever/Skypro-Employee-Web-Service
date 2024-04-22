package pro.sky.exever.employeelist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	
    public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping("/add")
    public String hello(@RequestParam (required = false, name = "firstName") String firstName,
    		@RequestParam (required = false, name = "lastName") String lastName) {
		return employeeService.addEmployee(firstName, lastName).toJson();
	}

}
