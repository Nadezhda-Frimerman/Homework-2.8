package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproempl.Exception.DepartmentNotFoundException;
import pro.sky.skyproempl.model.Employee;
import pro.sky.skyproempl.Exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;


    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;

    }

    public Double sumSalaryByDepartment(Integer department) {
        checkParameterDepartment(department);
        Double sumSalary = 0.0;
        for (int i = 0; i < getAllEmployeeByDepartment(department).size(); i++) {
            sumSalary += getAllEmployeeByDepartment(department).get(i).getSalary();
        }
        return sumSalary;
    }

    public Employee maxSalaryByDepartment(Integer department) {
        checkParameterDepartment(department);
        return getAllEmployeeByDepartment(department)
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee minSalaryByDepartment(Integer department) {
        checkParameterDepartment(department);
        return getAllEmployeeByDepartment(department)
                .stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public List<Employee> getAllEmployeeByDepartment(Integer department) {
        checkParameterDepartment(department);
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

    public void checkParameterDepartment(Integer department) {
        if (!employeeServiceImpl.getDepartments().contains(department)) {
            throw new DepartmentNotFoundException();
        }
    }


}
