package pro.sky.exever.employeewebservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static pro.sky.exever.employeewebservice.EmployeeConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    DepartmentServiceImpl departmentService;

    @BeforeEach
    public void beforeEach(){
        when(employeeService.all()).thenReturn(EMPLOYEES_GROUP_OF_10);
    }
    @Test
    void salaryMax() {
        assertThat(departmentService.salaryMax(4)).isEqualTo(100_000);
    }

    @Test
    void salaryMin() {
        assertThat(departmentService.salaryMin(4)).isEqualTo(70_000);
    }

    @Test
    void employeesFromDepartment() {
        assertThat(departmentService.employeesFromDepartment(4)).containsExactlyInAnyOrderElementsOf(List.of(EMPLOYEE_7, EMPLOYEE_8, EMPLOYEE_9, EMPLOYEE_10));
    }

    @Test
    void salarySum() {
        assertThat(departmentService.salarySum(4)).isEqualTo(70_000+80_000+90_000+100_000);
    }

    @Test
    void allEmployeesByDepartment() {
        assertThat(departmentService.allEmployeesByDepartment()).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        1, List.of(EMPLOYEE_1),
                        2, List.of(EMPLOYEE_2, EMPLOYEE_3),
                        3, List.of(EMPLOYEE_4, EMPLOYEE_5, EMPLOYEE_6),
                        4, List.of(EMPLOYEE_7, EMPLOYEE_8, EMPLOYEE_9, EMPLOYEE_10)
                )

        );
    }
}