package pro.sky.skyproempl.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParameterValidationException extends RuntimeException {
    public ParameterValidationException(String param) {
        super("Invalid parameter: %s".formatted(param));
    }
}
