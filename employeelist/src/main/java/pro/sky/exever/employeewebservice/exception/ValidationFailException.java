package pro.sky.exever.employeewebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationFailException extends RuntimeException {
	public ValidationFailException() {
		super("Ошибка валидации");
	}

	public ValidationFailException(String name) {
		super("Ошибка валидации %s".formatted(name));
	}

}
