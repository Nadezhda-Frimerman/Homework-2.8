package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.Employee;
import pro.sky.skyproempl.Exception.EmployeeAlreadyAddedException;
import pro.sky.skyproempl.Exception.EmployeeNotFoundException;
import pro.sky.skyproempl.Exception.EmployeeStorageIsFullException;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int employeeAmount;

    private Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employeeAmount = 12;
        this.employees = new HashMap<>(Map.of(
                "ОльгаКарманова", new Employee("Ольга", "Карманова", 3, 51200),
                "НатальяАронова", new Employee("Наталья", "Аронова", 1, 32800),
                "АнтонПиков", new Employee("Антон", "Пиков", 5, 37200),
                "ИльяОмутов", new Employee("Илья", "Омутов", 2, 43600),
                "МаринаТуманова", new Employee("Марина", "Туманова", 1, 21100),
                "АлексейПетров", new Employee("Алексей", "Петров", 4, 72300),
                "АлександрСватов", new Employee("Александр", "Сватов", 3, 54200),
                "ОксанаТунец", new Employee("Оксана", "Тунец", 1, 41200),
                "РоманКапустин", new Employee("Роман", "Капустин", 5, 47300),
                "ВадимМалых", new Employee("Вадим", "Малых", 2, 49100)));
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

    @Override
    public void addEmployee(String firstName, String lastName, int department, double salary) {
        if (employees.size() >= employeeAmount) {
            throw new EmployeeStorageIsFullException();
        }
        Employee e = new Employee(firstName, lastName, department, salary);
        if (employees.containsValue(e)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(firstName, lastName), e);


    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (!employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        } else return employees.get(createKey(firstName, lastName));
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        if (!employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        } else employees.remove(createKey(firstName, lastName));

    }
}
