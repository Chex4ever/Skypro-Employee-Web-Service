package pro.sky.exever.employeewebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EmployeeAlreadyAddedException extends RuntimeException {
	public EmployeeAlreadyAddedException() {
		super("Этот сотрудник уже есть в базе данных");
	}
	public EmployeeAlreadyAddedException(String name) {
		super("Cотрудник %s уже есть в базе данных".formatted(name));
	}
}