package pro.sky.exever.employeelist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
