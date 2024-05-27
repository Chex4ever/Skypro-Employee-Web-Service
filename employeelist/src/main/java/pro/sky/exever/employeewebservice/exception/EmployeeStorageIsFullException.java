package pro.sky.exever.employeewebservice.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
	public EmployeeStorageIsFullException() {
		super("База данных переполненна");
	}
}