package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    int getEmployeeAmount();

    Collection printAllEmployee();
    String createKey (String firstName, String lastName);

    String createKey(Employee e);

    void addEmployee(String firstName, String lastName, int department, double salary);

    Employee findEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);
}
