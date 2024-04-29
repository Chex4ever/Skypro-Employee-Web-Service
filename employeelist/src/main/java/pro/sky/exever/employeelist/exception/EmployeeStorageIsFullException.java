package pro.sky.exever.employeelist.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
	public EmployeeStorageIsFullException() {
		super("База данных переполненна");
	}
}