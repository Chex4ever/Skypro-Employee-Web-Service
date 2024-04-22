package pro.sky.exever.employeelist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeStorageIsFullException extends RuntimeException {

	public EmployeeStorageIsFullException() {
	}

	public EmployeeStorageIsFullException(String message) {
		super(message);
	}
}
