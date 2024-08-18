package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.Employee;

import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {
    Employee maxSalaryByDepartment(int department);

    Employee minSalaryByDepartment(int department);

    List<Employee> getAllEmployeeByDepartment(int department);

    Map<Integer, List<Employee>> getAllDepartmentsEployee();
}
