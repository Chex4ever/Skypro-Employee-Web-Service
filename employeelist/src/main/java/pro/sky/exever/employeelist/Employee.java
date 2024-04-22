package pro.sky.exever.employeelist;

import java.util.Objects;

public class Employee {
	private static int nextId = 1;
	private final int id;
	private String lastName;
	private String firstName;

	public Employee(String surname, String name) {
		this.id = nextId++;
		this.firstName = name;
		this.lastName = surname;
	}

	public int getId() { return this.id; }
	public String getName() { return this.firstName; }
	public String getSurname() { return this.lastName; }
	public void setName(String name) { this.firstName = name; }
	public String toJson() {
		return "{\"firstName\": \""+firstName+"\", \"lastName\": \""+lastName+"\" }";
	}
	public void setSurname(String surname) { this.lastName = surname;}
	@Override
	public int hashCode() { return Objects.hash(lastName, firstName); }
	@Override
	public String toString() {
		return "id " + this.id + ", ФИО: " + this.lastName + " " + this.firstName;
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