package pro.sky.exever.employeelist;

public class EmployeeAlreadyAddedException extends RuntimeException {
	public EmployeeAlreadyAddedException() {
		super("Этот сотрудник уже есть в базе данных");
	}
}