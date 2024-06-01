package pro.sky.exever.employeewebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/min-salary")
	public Employee minSalary(@RequestParam int departmentId) {
		return departmentService.minSalary(departmentId);
	}

	@GetMapping("/max-salary")
	public Employee maxSalary(@RequestParam int departmentId) {
		return departmentService.maxSalary(departmentId);
	}

	@GetMapping("/all")
	public Map<Integer, List<Employee>> allEmployeesByDepartment() {
		return departmentService.allEmployeesByDepartment();
	}

	@GetMapping(value = "/all", params = { "departmentId" })
	public Collection<Employee> employeesFromDepartment(@RequestParam int departmentId) {
		return departmentService.employeesFromDepartment(departmentId);
	}
}
