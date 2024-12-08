package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.model.Employee;

import java.util.List;

@Service
public interface EmployeeService {
    int getEmployeeAmount();

    List<Employee> findAllEmployees();

    String createKey(String firstName, String lastName);

    String createKey(Employee e);

    Employee addEmployee(String firstName, String lastName, Integer department, Double salary);

    Employee findEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);
}
