package pro.sky.skyproempl.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "сотрудник не найден")
public class EmployeeNotFoundException extends RuntimeException{
    public String EmployeeNotFoundException(){
        return "сотрудник не найден";
    }
}
