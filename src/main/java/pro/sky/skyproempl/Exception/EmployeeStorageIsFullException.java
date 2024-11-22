package pro.sky.skyproempl.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,reason = "превышен лимит количества сотрудников в фирме")
public class EmployeeStorageIsFullException extends RuntimeException {
    public String EmployeeStorageIsFullException() {
        return ("превышен лимит количества сотрудников в фирме");
    }
}
