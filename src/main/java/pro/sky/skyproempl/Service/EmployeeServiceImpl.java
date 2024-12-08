package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.Exception.DepartmentNotFoundException;
import pro.sky.skyproempl.model.Employee;
import pro.sky.skyproempl.Exception.EmployeeAlreadyAddedException;
import pro.sky.skyproempl.Exception.EmployeeNotFoundException;
import pro.sky.skyproempl.Exception.EmployeeStorageIsFullException;
import pro.sky.skyproempl.Validation.ParameterValidator;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int employeeAmount;
    private final Set<Integer> departments;
    private final Map<String, Employee> employees;
    private final ParameterValidator parameterValidator;

    public EmployeeServiceImpl(ParameterValidator parameterValidator) {
        this.parameterValidator = parameterValidator;
        this.employeeAmount = 12;
        this.departments = new HashSet<Integer>(Set.of(1, 2, 3, 4, 5));
        this.employees = new HashMap<>(Map.of(
                "ОльгаКарманова", new Employee("Ольга", "Карманова", 3, 51200.0),
                "НатальяАронова", new Employee("Наталья", "Аронова", 1, 32800.0),
                "АнтонПиков", new Employee("Антон", "Пиков", 5, 37200.0),
                "ИльяОмутов", new Employee("Илья", "Омутов", 2, 43600.0),
                "МаринаТуманова", new Employee("Марина", "Туманова", 1, 21100.0),
                "АлексейПетров", new Employee("Алексей", "Петров", 4, 72300.0),
                "АлександрСватов", new Employee("Александр", "Сватов", 3, 54200.0),
                "ОксанаТунец", new Employee("Оксана", "Тунец", 1, 41200.0),
                "РоманКапустин", new Employee("Роман", "Капустин", 5, 47300.0),
                "ВадимМалых", new Employee("Вадим", "Малых", 2, 49100.0)));
    }

    @Override
    public int getEmployeeAmount() {
        return employeeAmount;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employees.values()
                .stream()
                .toList();

    }

    @Override
    public String createKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    @Override
    public String createKey(Employee e) {
        return e.getFirstName() + e.getLastName();
    }

    public Set<Integer> getDepartments() {
        return departments;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer department, Double salary) {
        if (employees.size() >= employeeAmount) {
            throw new EmployeeStorageIsFullException();
        }
        parameterValidator.checkParameterName(firstName);
        parameterValidator.checkParameterName(lastName);
        firstName = parameterValidator.formatParameterName(firstName);
        lastName = parameterValidator.formatParameterName(lastName);
        if (!getDepartments().contains(department)) {
            throw new DepartmentNotFoundException();
        }
        Employee e = new Employee(firstName, lastName, department, salary);
        if (employees.containsValue(e)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(firstName, lastName), e);
        return e;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        parameterValidator.checkParameterName(firstName);
        parameterValidator.checkParameterName(lastName);
        firstName = parameterValidator.formatParameterName(firstName);
        lastName = parameterValidator.formatParameterName(lastName);
        if (!employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        } else return employees.get(createKey(firstName, lastName));
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        parameterValidator.checkParameterName(firstName);
        parameterValidator.checkParameterName(lastName);
        firstName = parameterValidator.formatParameterName(firstName);
        lastName = parameterValidator.formatParameterName(lastName);
        if (!employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        } else return employees.remove(createKey(firstName, lastName));

    }

}
