package pro.sky.exever.employeewebservice.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
	public EmployeeAlreadyAddedException() {
		super("Этот сотрудник уже есть в базе данных");
	}
}