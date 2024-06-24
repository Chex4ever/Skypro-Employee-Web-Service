package pro.sky.exever.employeewebservice;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/{id}/salary/min")
	public int salaryMin(@PathVariable("id") int departmentId) {
		return departmentService.salaryMin(departmentId);
	}

	@GetMapping("/{id}/salary/max")
	public int salaryMax(@PathVariable("id") int departmentId) {
		return departmentService.salaryMax(departmentId);
	}
	@GetMapping("/{id}/salary/sum")
	public int salarySum(@PathVariable("id") int departmentId) {
		return departmentService.salarySum(departmentId);
	}

	@GetMapping("/{id}/all")
	public Map<Integer, List<Employee>> allEmployeesByDepartment() {
		return departmentService.allEmployeesByDepartment();
	}

	@GetMapping(value = "/{id}/all", params = { "departmentId" })
	public Collection<Employee> employeesFromDepartment(@RequestParam int departmentId) {
		return departmentService.employeesFromDepartment(departmentId);
	}
}
