package pro.sky.skyproempl.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyproempl.Exception.DepartmentNotFoundException;
import pro.sky.skyproempl.Validation.ParameterValidator;
import pro.sky.skyproempl.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private static final Collection<Employee> employees = List.of(
            new Employee("Ann", "Silver", 2, 5000.0),
            new Employee("Tom", "Tompson", 1, 3000.0),
            new Employee("Helen", "Prow", 1, 3200.0),
            new Employee("Jack", "Green", 2, 4000.0)
    );
    private static final Set<Integer> departments = new HashSet<Integer>(Set.of(1, 2));

    @Test
    void getSumSalaryByDepartment_WhenCorrectParams_ThanReturnCorrectSum() {
        when(employeeService.findAllEmployees()).thenReturn((List<Employee>) employees);
        Integer department = employees.iterator().next().getDepartment();
        Double expected = 0.00;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                expected += employee.getSalary();
            }
        }
        //test
        Double actual = departmentService.sumSalaryByDepartment(department);
        //check
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void sumSalaryByDepartment_WhenDepartmentIsNotExist_ThanThenThrowException() {
        when(employeeService.getDepartments()).thenReturn(departments);
        //test and check
        assertThatExceptionOfType(DepartmentNotFoundException.class)
                .isThrownBy(() -> departmentService.sumSalaryByDepartment(3));
    }

    @Test
    void maxSalaryByDepartment_WhenCorrectParams_ThanReturnCorrectMaxSalary() {
        when(employeeService.findAllEmployees()).thenReturn((List<Employee>) employees);
        when(employeeService.getDepartments()).thenReturn(departments);
        Integer department = employees.iterator().next().getDepartment();
        Employee expected = employees.stream()
                .filter(emp -> emp.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
        //test
        Employee actual = departmentService.maxSalaryByDepartment(department);
        //check
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void maxSalaryByDepartment_WhenDepartmentIsNotExist_ThanThenThrowException() {
        when(employeeService.getDepartments()).thenReturn(departments);
        //test and check
        assertThatExceptionOfType(DepartmentNotFoundException.class)
                .isThrownBy(() -> departmentService.sumSalaryByDepartment(3));
    }

    @Test
    void minSalaryByDepartment_WhenCorrectParams_ThanReturnCorrectMinSalary() {
        when(employeeService.findAllEmployees()).thenReturn((List<Employee>) employees);
        when(employeeService.getDepartments()).thenReturn(departments);
        Integer department = employees.iterator().next().getDepartment();
        Employee expected = employees.stream()
                .filter(emp -> emp.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
        ;
        //test
        Employee actual = departmentService.minSalaryByDepartment(department);
        //check
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void minSalaryByDepartment_WhenDepartmentIsNotExist_ThanThenThrowException() {
        when(employeeService.getDepartments()).thenReturn(departments);
        //test and check
        assertThatExceptionOfType(DepartmentNotFoundException.class)
                .isThrownBy(() -> departmentService.sumSalaryByDepartment(3));
    }

    @Test
    void getAllEmployeeByDepartment_WhenCorrectParams_ThanReturnListEmployee() {
        when(employeeService.findAllEmployees()).thenReturn((List<Employee>) employees);
        when(employeeService.getDepartments()).thenReturn(departments);
        Integer department = employees.iterator().next().getDepartment();
        List<Employee> expected = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                expected.add(employee);
            }
        }
        //test
        List<Employee> actual = departmentService.getAllEmployeeByDepartment(department);
        //check
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void getAllEmployeeByDepartment_WhenDepartmentIsNotExist_ThanThenThrowException() {
        when(employeeService.getDepartments()).thenReturn(departments);
        //test and check
        assertThatExceptionOfType(DepartmentNotFoundException.class)
                .isThrownBy(() -> departmentService.getAllEmployeeByDepartment(3));
    }

    @Test
    void getAllDepartmentsEployee() {
        when(employeeService.findAllEmployees()).thenReturn((List<Employee>) employees);
        Map<Integer, List<Employee>> expected = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
        //test
        Map<Integer, List<Employee>> actual = departmentService.getAllDepartmentsEployee();
        //check
        assertThat(actual).containsExactlyInAnyOrderEntriesOf(expected);
    }

}