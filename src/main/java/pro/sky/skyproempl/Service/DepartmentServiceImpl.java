package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.skyproempl.Employee;
import pro.sky.skyproempl.Exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public Employee maxSalaryByDepartment(int department) {
        return getAllEmployeeByDepartment(department)
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee minSalaryByDepartment(int department) {
        return getAllEmployeeByDepartment(department)
                .stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public List<Employee> getAllEmployeeByDepartment(int department) {
        return employeeServiceImpl.findAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }

    public Map<Integer, List<Employee>> getAllDepartmentsEployee() {
        return employeeServiceImpl.findAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }
}
