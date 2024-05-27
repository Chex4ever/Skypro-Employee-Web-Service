package pro.sky.exever.employeewebservice;

import java.util.Objects;

public class Employee {
	private String lastName;
	private String firstName;
	private int salary;
	private int departmentId;

	public Employee(String lastName, String firstName, int salary, int departmentId) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.departmentId = departmentId;
	}

	// @formatter:off
	public String getFirstName() { return this.firstName; }
	public void setFirstName(String name) { this.firstName = name; }
	public String getLastName() { return this.lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
	public int getDepartmentId() { return departmentId; }
	public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }
	// @formatter:on
	
	@Override
	public int hashCode() {
		return Objects.hash(lastName, firstName);
	}

	@Override
	public String toString() {
		return this.lastName + " " + this.firstName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}
}