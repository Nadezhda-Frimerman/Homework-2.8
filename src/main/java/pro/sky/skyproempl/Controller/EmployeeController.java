package pro.sky.skyproempl.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproempl.Service.EmployeeService;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping (path = "/print")
    public String printEmployees(){
        return employeeService.printAllEmployee();
    }
    @GetMapping("/add")
    public void addEmployee(@RequestParam (value = "firstName") String firstName,
                            @RequestParam (value = "lastName") String lastName){
        employeeService.addEmployee(firstName,lastName);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam (value = "firstName") String firstName,
                               @RequestParam (value = "lastName") String lastName){
        return employeeService.findEmployee(firstName,lastName).toString();
    }
    @GetMapping("/remove")
    public void removeEmployee(@RequestParam (value = "firstName") String firstName,
                               @RequestParam (value = "lastName") String lastName){
        employeeService.removeEmployee(firstName,lastName);
    }
}
