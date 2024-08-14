package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.Employee;
@Service
public interface EmployeeService {
    int getEmployeeAmount();

    String printAllEmployee();

    void addEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);
}
