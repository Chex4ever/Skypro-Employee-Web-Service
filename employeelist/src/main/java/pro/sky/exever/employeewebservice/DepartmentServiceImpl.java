package pro.sky.exever.employeewebservice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pro.sky.exever.employeewebservice.exception.EmployeeNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private final EmployeeService employeeService;
	
	public DepartmentServiceImpl(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Override
	public Employee maxSalary(int departmentId) {
		return employeeService.allEmployees().stream()
				.filter(e -> e.getDepartmentId() == departmentId)
				.max(Comparator.comparingInt(Employee::getSalary))
				.orElseThrow(EmployeeNotFoundException::new);
	}
	@Override
	public Employee minSalary(int departmentId) {
		return employeeService.allEmployees().stream()
				.filter(e -> e.getDepartmentId() == departmentId)
				.min(Comparator.comparingInt(Employee::getSalary))
				.orElseThrow(EmployeeNotFoundException::new);
	}
	@Override
	public List<Employee> employeesFromDepartment(int departmentId){
		return employeeService.allEmployees().stream()
				.filter(e -> e.getDepartmentId() == departmentId)
				.collect(Collectors.toList());
	}
	@Override
	public Map<Integer, List<Employee>> allEmployeesByDepartment(){
		return employeeService.allEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentId));
	}
	
	
	
	
}
