package pro.sky.exever.employeewebservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.exever.employeewebservice.exception.EmployeeAlreadyAddedException;
import pro.sky.exever.employeewebservice.exception.EmployeeNotFoundException;
import pro.sky.exever.employeewebservice.exception.EmployeeStorageIsFullException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static pro.sky.exever.employeewebservice.EmployeeConstants.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private ValidationService validationService;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void beforeEach(){
        when(validationService.validateName(anyString())).then(returnsFirstArg());
    }

    @Test
    void addTest() {
        Employee actual = employeeService.add(EMPLOYEE_1.getLastName(), EMPLOYEE_1.getFirstName(), EMPLOYEE_1.getSalary(), EMPLOYEE_1.getDepartmentId());
        assertThat(actual).isEqualTo(EMPLOYEE_1);
        assertThat(employeeService.all()).containsExactlyInAnyOrderElementsOf(List.of(EMPLOYEE_1));

        actual = employeeService.add(EMPLOYEE_2.getLastName(), EMPLOYEE_2.getFirstName(), EMPLOYEE_2.getSalary(), EMPLOYEE_2.getDepartmentId());
        assertThat(actual).isEqualTo(EMPLOYEE_2);
        assertThat(employeeService.all()).containsExactlyInAnyOrderElementsOf(List.of(EMPLOYEE_1, EMPLOYEE_2));
    }
    @Test
    void addOverMaxTest() {
        EMPLOYEES_GROUP_OF_10.forEach(employee -> employeeService.add(employee.getLastName(), employee.getFirstName(), employee.getSalary(), employee.getDepartmentId()));
        assertThatExceptionOfType(EmployeeStorageIsFullException.class).isThrownBy(() -> employeeService.add(EMPLOYEE_11.getLastName(),EMPLOYEE_11.getFirstName(),EMPLOYEE_11.getSalary(),EMPLOYEE_11.getDepartmentId()));
    }
    @Test
    void addDuplicateTest() {
        employeeService.add(EMPLOYEE_11.getLastName(), EMPLOYEE_11.getFirstName(), EMPLOYEE_11.getSalary(), EMPLOYEE_11.getDepartmentId());
        assertThatExceptionOfType(EmployeeAlreadyAddedException.class).isThrownBy(() -> employeeService.add(EMPLOYEE_11.getLastName(),EMPLOYEE_11.getFirstName(),EMPLOYEE_11.getSalary(),EMPLOYEE_11.getDepartmentId()));
    }


    @Test
    void removeTest() {
        EMPLOYEES_GROUP_OF_5.forEach(employee -> employeeService.add(employee.getLastName(), employee.getFirstName(), employee.getSalary(), employee.getDepartmentId()));
        Employee actual = employeeService.remove(EMPLOYEE_3.getLastName(), EMPLOYEE_3.getFirstName());
        assertThat(actual).isEqualTo(EMPLOYEE_3);
        assertThat(employeeService.all()).containsExactlyInAnyOrderElementsOf(List.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_4, EMPLOYEE_5));

        actual = employeeService.remove(EMPLOYEE_4.getLastName(), EMPLOYEE_4.getFirstName());
        assertThat(actual).isEqualTo(EMPLOYEE_4);
        assertThat(employeeService.all()).containsExactlyInAnyOrderElementsOf(List.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_5));
    }

    @Test
    void allTest() {
        EMPLOYEES_GROUP_OF_10.forEach(employee -> employeeService.add(employee.getLastName(), employee.getFirstName(), employee.getSalary(), employee.getDepartmentId()));
        assertThat(employeeService.all()).containsExactlyInAnyOrderElementsOf(EMPLOYEES_GROUP_OF_10);
    }

    @Test
    void findTest() {
        EMPLOYEES_GROUP_OF_10.forEach(employee -> employeeService.add(employee.getLastName(), employee.getFirstName(), employee.getSalary(), employee.getDepartmentId()));
        assertThat(employeeService.find(EMPLOYEE_5.getLastName(),EMPLOYEE_5.getFirstName())).isEqualTo(EMPLOYEE_5);
    }
    @Test
    void findNegativeTest() {
        EMPLOYEES_GROUP_OF_10.forEach(employee -> employeeService.add(employee.getLastName(), employee.getFirstName(), employee.getSalary(), employee.getDepartmentId()));
        assertThatExceptionOfType(EmployeeNotFoundException.class).isThrownBy(()->employeeService.find(EMPLOYEE_11.getLastName(),EMPLOYEE_11.getFirstName()));
    }
}