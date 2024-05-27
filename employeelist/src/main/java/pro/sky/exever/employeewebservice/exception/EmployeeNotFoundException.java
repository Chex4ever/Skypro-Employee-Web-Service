package pro.sky.exever.employeewebservice.exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException() {
		super("Сотрудник с данным ФИО не найден");
	}
}