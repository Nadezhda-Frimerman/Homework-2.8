package pro.sky.skyproempl.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproempl.Service.EmployeeService;
import pro.sky.skyproempl.Service.EmployeeServiceImpl;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }
    @GetMapping (path = "/print")
    public String printEmployees(){
        return employeeServiceImpl.printAllEmployee();
    }
    @GetMapping("/add")
    public String addEmployee(@RequestParam (value = "firstName") String firstName,
                            @RequestParam (value = "lastName") String lastName){
        return employeeServiceImpl.addEmployee(firstName,lastName);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam (value = "firstName") String firstName,
                               @RequestParam (value = "lastName") String lastName){
        return employeeServiceImpl.findEmployee(firstName,lastName).toString();
    }
    @GetMapping("/remove")
    public void removeEmployee(@RequestParam (value = "firstName") String firstName,
                               @RequestParam (value = "lastName") String lastName){
        employeeServiceImpl.removeEmployee(firstName,lastName);
    }
}
