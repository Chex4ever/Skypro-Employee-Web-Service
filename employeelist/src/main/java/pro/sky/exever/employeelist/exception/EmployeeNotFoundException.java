package pro.sky.exever.employeelist.exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException() {
		super("Сотрудник с данным ФИО не найден");
	}
}