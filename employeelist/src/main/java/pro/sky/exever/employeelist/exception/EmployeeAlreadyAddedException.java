package pro.sky.exever.employeelist.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
	public EmployeeAlreadyAddedException() {
		super("Этот сотрудник уже есть в базе данных");
	}
}