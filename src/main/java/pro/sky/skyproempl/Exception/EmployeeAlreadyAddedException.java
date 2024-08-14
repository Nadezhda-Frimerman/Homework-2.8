package pro.sky.skyproempl.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "уже есть такой сотрудник")
public class EmployeeAlreadyAddedException extends RuntimeException {
    public String EmployeeAlreadyAddedException () {
        return ("уже есть такой сотрудник");
    }
}
