package pro.sky.exever.employeewebservice;

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
	public int salaryMax(int departmentId) {
		return employeeService.all().stream()
				.filter(e -> e.getDepartmentId() == departmentId)
				.mapToInt(Employee::getSalary)
				.max()
				.orElseThrow(EmployeeNotFoundException::new);
	}
	@Override
	public int salaryMin(int departmentId) {
		return employeeService.all().stream()
				.filter(e -> e.getDepartmentId() == departmentId)
				.mapToInt(Employee::getSalary)
				.min()
				.orElseThrow(EmployeeNotFoundException::new);
	}
	@Override
	public List<Employee> employeesFromDepartment(int departmentId){
		return employeeService.all().stream()
				.filter(e -> e.getDepartmentId() == departmentId)
				.toList();
	}
	@Override
	public int salarySum(int departmentId) {
		return employeeService.all().stream()
				.filter(e -> e.getDepartmentId() == departmentId)
				.mapToInt(Employee::getSalary)
				.sum();
	}
	@Override
	public Map<Integer, List<Employee>> allEmployeesByDepartment(){
		return employeeService.all().stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentId));
	}
}
