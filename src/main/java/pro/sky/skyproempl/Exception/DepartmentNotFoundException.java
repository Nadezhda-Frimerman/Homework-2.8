package pro.sky.skyproempl.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "отдел не найден")
public class DepartmentNotFoundException extends RuntimeException{
    public String DepartmentNotFoundException(){
        return "отдел не найден";
    }
}
