package pro.sky.skyproempl.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.skyproempl.Employee;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public Employee maxSalaryByDepartment(int department){
        return
    }
}
