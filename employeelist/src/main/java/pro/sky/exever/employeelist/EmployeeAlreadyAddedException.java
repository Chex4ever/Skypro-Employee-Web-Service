package pro.sky.exever.employeelist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployeeAlreadyAddedException extends RuntimeException {
	public EmployeeAlreadyAddedException() {
	}
	public EmployeeAlreadyAddedException(String message) {
		super(message);
	}
}
