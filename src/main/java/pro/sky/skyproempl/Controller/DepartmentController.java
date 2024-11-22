package pro.sky.skyproempl.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproempl.Employee;
import pro.sky.skyproempl.Service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController

public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryByDepartment(@RequestParam(value = "department") int department) {
        return departmentServiceImpl.maxSalaryByDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryByDepartment(@RequestParam(value = "department") int department) {
        return departmentServiceImpl.minSalaryByDepartment(department);
    }

    @GetMapping("/all-by-departments")
    public List<Employee> getAllEmployeeByDepartment(@RequestParam(value = "department") int department) {
        return departmentServiceImpl.getAllEmployeeByDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllDepartmentsEmployee() {
        return departmentServiceImpl.getAllDepartmentsEployee();
    }
}