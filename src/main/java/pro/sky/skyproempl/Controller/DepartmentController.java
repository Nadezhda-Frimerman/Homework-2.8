package pro.sky.skyproempl.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproempl.Employee;

@RestController
@RequestMapping("/department")
public class DepartmentController {

@GetMapping("/max-salary")
public Employee maxSalaryByDepartment(@RequestParam(value = "department") int department){
    return
}

}