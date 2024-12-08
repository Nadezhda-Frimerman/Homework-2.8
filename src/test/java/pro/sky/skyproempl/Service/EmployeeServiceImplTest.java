package pro.sky.skyproempl.Service;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.skyproempl.Exception.EmployeeAlreadyAddedException;
import pro.sky.skyproempl.Exception.EmployeeNotFoundException;
import pro.sky.skyproempl.Exception.EmployeeStorageIsFullException;
import pro.sky.skyproempl.Exception.ParameterValidationException;
import pro.sky.skyproempl.Validation.ParameterValidator;
import pro.sky.skyproempl.model.Employee;

import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(new ParameterValidator());

    @Test
    void shouldFindEmployee_WhenEmployeeExist_ThenReturnEmployee() {
        String firstName = "Tom";
        String lastName = "Swen";
        Integer department = 2;
        Double salary = 1000.00;
        Employee expected = employeeService.addEmployee(firstName, lastName, department, salary);
        //test
        Employee actual = employeeService.findEmployee(firstName, lastName);
        //check
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void shouldFindEmployee_WhenEmployeeNotExist_ThenThrowException() {
        String firstName = "Tom";
        String lastName = "Swen";

        //test and check
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.findEmployee(firstName, lastName));
    }

    @Test
    void shouldAddEmployee_WhenCorrectParams_ThenAdd() {
        String firstName = "Tom";
        String lastName = "Swen";
        Integer department = 2;
        Double salary = 1000.00;

        // test
        Employee actual = employeeService.addEmployee(firstName, lastName, department, salary);
        //check
        assertThat(actual.getFirstName()).isEqualTo(firstName);
        assertThat(actual.getLastName()).isEqualTo(lastName);
        assertThat(actual.getDepartment()).isEqualTo(department);
        assertThat(actual.getSalary()).isEqualTo(salary);
    }

    @Test
    void shouldAddEmployee_WhenTooManyEmployees_ThenThrowException() {
        String firstName = "Tom";
        String lastName = "Swen";
        Integer department = 2;
        Double salary = 1000.00;
        String lastNameA = "a";
        for (int i = 0; i <= employeeService.getEmployeeAmount() - employeeService.findAllEmployees().size(); i++) {
            lastNameA = lastNameA + "a";
            employeeService.addEmployee(firstName, lastNameA, department, salary);

        }
        //test and check
        assertThatExceptionOfType(EmployeeStorageIsFullException.class)
                .isThrownBy(() -> employeeService.addEmployee(firstName, lastName, department, salary));
    }

    @Test
    void shouldAddEmployee_WhenEmployeeAlreadyAdded_ThenThrowException() {
        String firstName = "Tom";
        String lastName = "Swen";
        Integer department = 2;
        Double salary = 1000.00;
        employeeService.addEmployee(firstName, lastName, department, salary);
        //test and check
        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(() -> employeeService.addEmployee(firstName, lastName, department, salary));
    }

    @ParameterizedTest
    @MethodSource("provideIncorrectParams")
    void shouldAddEmployee_WhenIncorrectParams_ThanThrowException(String message, String firstName, String lastname) {
        Integer department = 2;
        Double salary = 1000.00;

        //test & check
        assertThatExceptionOfType(ParameterValidationException.class).
                isThrownBy(() -> employeeService.addEmployee(firstName, lastname, department, salary));
    }

    @Test
    void shouldAddEmployee_WhenParamsIsLowwer_ThanCapitolizeFirstLetter() {
        String firstName = "tom";
        String lastName = "swen";
        Integer department = 2;
        Double salary = 1000.00;
        //test
        Employee actual = employeeService.addEmployee(firstName, lastName, department, salary);
        //check
        assertThat(actual.getFirstName()).isEqualTo(StringUtils.capitalize(firstName));
        assertThat(actual.getLastName()).isEqualTo(StringUtils.capitalize(lastName));
    }

    @Test
    void shouldRemoveEmployee_WhenEmployeeExist_ThenEmployeeRemoved() {
        String firstName = "Tom";
        String lastName = "Swen";
        Integer department = 2;
        Double salary = 1000.00;
        Employee expected = employeeService.addEmployee(firstName, lastName, department, salary);
        //test
        Employee actual = employeeService.removeEmployee(firstName, lastName);
        //check
        assertThat(actual).isEqualTo(expected);
        Collection<Employee> actualEmployees = employeeService.findAllEmployees();
        assertThat(actualEmployees).doesNotContain(expected);
    }

    @Test
    void shouldRemoveEmployee_WhenEmployeeNotExist_ThenThrowException() {
        String firstName = "Tom";
        String lastName = "Swen";

        //test and check
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.removeEmployee(firstName, lastName));
    }

    private static Stream<Arguments> provideIncorrectParams() {
        return Stream.of(Arguments.of("Incorrect first param", "T1m", "Swen"),
                Arguments.of("Incorrect second param", "Tom", "Sw1n"),
                Arguments.of("Both params are incorrect", "T1m", "Sw1n"));
    }
}