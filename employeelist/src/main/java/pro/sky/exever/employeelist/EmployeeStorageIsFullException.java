package pro.sky.exever.employeelist;

public class EmployeeStorageIsFullException extends RuntimeException {
	public EmployeeStorageIsFullException() {
		super("База данных переполненна");
	}
}