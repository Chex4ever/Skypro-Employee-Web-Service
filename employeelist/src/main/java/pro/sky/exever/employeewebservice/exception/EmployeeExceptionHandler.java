package pro.sky.exever.employeewebservice.exception;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	private static final Logger LOG = Logger.getLogger("EmployeeExceptionHandler.class");

	@ExceptionHandler(EmployeeAlreadyAddedException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public String handleException(EmployeeAlreadyAddedException e) {
		LOG.severe(e.getMessage());
		return (e.getMessage());
	}
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleException(EmployeeNotFoundException e) {
		LOG.severe(e.getMessage());
		return (e.getMessage());
	}
	@ExceptionHandler(EmployeeStorageIsFullException.class)
	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
	public String handleException(EmployeeStorageIsFullException e) {
		LOG.severe(e.getMessage());
		return (e.getMessage());
	}
	@ExceptionHandler(ValidationFailException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleException(ValidationFailException e) {
		LOG.severe(e.getMessage());
		return (e.getMessage());
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleException(RuntimeException e) {
		LOG.severe(e.getMessage());
		return (e.getMessage());
	}
}
