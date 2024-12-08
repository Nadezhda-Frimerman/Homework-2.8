package pro.sky.skyproempl.Controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import pro.sky.skyproempl.model.Employee;
import pro.sky.skyproempl.Service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }
    @GetMapping("/{id}/salary/sum")
    public Double sumSalaryByDepartment(@PathVariable("id") Integer department) {
        return departmentServiceImpl.sumSalaryByDepartment(department);
    }
    @GetMapping("/{id}/salary/max")
    public Employee maxSalaryByDepartment(@PathVariable("id") Integer department) {
        return departmentServiceImpl.maxSalaryByDepartment(department);
    }

    @GetMapping("/{id}/salary/min")
    public Employee minSalaryByDepartment(@PathVariable("id") Integer department) {
        return departmentServiceImpl.minSalaryByDepartment(department);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeeByDepartment(@PathVariable("id") Integer department) {
        return departmentServiceImpl.getAllEmployeeByDepartment(department);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllDepartmentsEmployee() {
        return departmentServiceImpl.getAllDepartmentsEployee();
    }
}