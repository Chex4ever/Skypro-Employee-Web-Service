package pro.sky.exever.employeewebservice;

import org.junit.jupiter.api.Test;
import pro.sky.exever.employeewebservice.exception.ValidationFailException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.exever.employeewebservice.EmployeeConstants.*;

class ValdationServiceImplTest {
    ValidationService validationService= new ValdationServiceImpl();
    @Test
    void validateNameCapitaliseTest() {
        assertEquals(EMPLOYEE_CAPS_NAME_VALIDATED, validationService.validateName(EMPLOYEE_CAPS_NAME));
    }
    @Test
    void validateNameNegativeTest() {
        assertThrows(ValidationFailException.class, () -> validationService.validateName(EMPLOYEE_BAD_NAME));
    }
}