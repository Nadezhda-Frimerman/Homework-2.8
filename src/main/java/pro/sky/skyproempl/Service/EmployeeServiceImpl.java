package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.Employee;
import pro.sky.skyproempl.Exception.EmployeeAlreadyAddedException;
import pro.sky.skyproempl.Exception.EmployeeNotFoundException;
import pro.sky.skyproempl.Exception.EmployeeStorageIsFullException;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int employeeAmount;

    private Map<String,Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = Map.of(
                "ОльгаКарманова", new Employee("Ольга", "Карманова"),
                "ИванПетров", new Employee("Иван", "Петров"),
                "НатальяАронова", new Employee("Наталья", "Аронова"),
                "АнтонПиков", new Employee("Антон", "Пиков"));
        this.employeeAmount=10;
    }

    @Override
    public int getEmployeeAmount() {
        return employeeAmount;
    }

    @Override
    public String printAllEmployee() {
        return employees.toString();
    }

    @Override
    public String addEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        String k=firstName+lastName;
        if (employees.size() >= employeeAmount) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.containsValue(e)) {
            throw new EmployeeAlreadyAddedException();
        }
        else {
            employees.put(k,e);
            return "add";
        }

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName+lastName)){
                return employees.get(firstName+lastName);
            }
        else throw new EmployeeNotFoundException();
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
                employees.remove(firstName+lastName);

    }
}
