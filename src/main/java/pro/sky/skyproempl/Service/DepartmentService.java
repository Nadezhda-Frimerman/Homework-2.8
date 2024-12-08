package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.model.Employee;

import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {
    Double sumSalaryByDepartment(Integer department);
    Employee maxSalaryByDepartment(Integer department);

    Employee minSalaryByDepartment(Integer department);

    List<Employee> getAllEmployeeByDepartment(Integer department);

    Map<Integer, List<Employee>> getAllDepartmentsEployee();
}
