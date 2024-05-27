package pro.sky.exever.employeewebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException() {
		super("Сотрудник с данным ФИО не найден");
	}
	public EmployeeNotFoundException(String name) {
		super("Сотрудник %s не найден".formatted(name));
	}
}