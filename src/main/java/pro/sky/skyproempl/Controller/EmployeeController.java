package pro.sky.skyproempl.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproempl.model.Employee;
import pro.sky.skyproempl.Service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/print")
    public List<Employee> allEmployees() {
        return employeeServiceImpl.findAllEmployees();
    }

    @GetMapping("/add")
    public void addEmployee(@RequestParam(value = "firstName") String firstName,
                            @RequestParam(value = "lastName") String lastName,
                            @RequestParam(value = "department") Integer department,
                            @RequestParam(value = "salary") Double salary) {
        employeeServiceImpl.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName") String lastName) {
        return employeeServiceImpl.findEmployee(firstName, lastName).toString();
    }

    @GetMapping("/remove")
    public void removeEmployee(@RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName") String lastName) {
        employeeServiceImpl.removeEmployee(firstName, lastName);
    }
}
