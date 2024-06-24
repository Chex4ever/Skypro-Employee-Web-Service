package pro.sky.exever.employeewebservice;

import java.util.List;

public class EmployeeConstants
{
    public static final Employee EMPLOYEE_1 = new Employee("Иванов", "Иван", 10_000, 1);
    public static final Employee EMPLOYEE_2 = new Employee("Петров", "Петр", 20_000, 2);
    public static final Employee EMPLOYEE_3 = new Employee("Сидоров", "Сидр", 30_000, 2);
    public static final Employee EMPLOYEE_4 = new Employee("Кузнецов", "Кузнец", 40_000, 3);
    public static final Employee EMPLOYEE_5 = new Employee("Охлобыстин", "Иван", 50_000, 3);
    public static final Employee EMPLOYEE_6 = new Employee("Иванов", "Евгений", 60_000, 3);
    public static final Employee EMPLOYEE_7 = new Employee("Александров", "Александр", 90_000, 4);
    public static final Employee EMPLOYEE_8 = new Employee("Сидоров", "Иван", 80_000, 4);
    public static final Employee EMPLOYEE_9 = new Employee("Петров", "Иван", 70_000, 4);
    public static final Employee EMPLOYEE_10 = new Employee("Иванов", "Петр", 100_000, 4);
    public static final Employee EMPLOYEE_11 = new Employee("Курва", "Бобер", 110_000, 5);
    public static final String EMPLOYEE_BAD_NAME = "П7@x03 NMR";
    public static final String EMPLOYEE_CAPS_NAME = "КАПС";
    public static final String EMPLOYEE_CAPS_NAME_VALIDATED = "Капс";
    public static final List<Employee> EMPLOYEES_GROUP_OF_5 =List.of(EMPLOYEE_1,EMPLOYEE_2,EMPLOYEE_3,EMPLOYEE_4,EMPLOYEE_5);
    public static final List<Employee> EMPLOYEES_GROUP_OF_10 =List.of(EMPLOYEE_1,EMPLOYEE_2,EMPLOYEE_3,EMPLOYEE_4,EMPLOYEE_5,EMPLOYEE_6,EMPLOYEE_7,EMPLOYEE_8,EMPLOYEE_9,EMPLOYEE_10);
}
