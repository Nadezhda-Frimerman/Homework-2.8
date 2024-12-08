package pro.sky.skyproempl.Validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pro.sky.skyproempl.Exception.DepartmentNotFoundException;
import pro.sky.skyproempl.Exception.ParameterValidationException;

import java.util.*;

@Component
public class ParameterValidator {
    public void checkParameterName(String param) {
        if (!StringUtils.isAlpha(param)) {
            throw new ParameterValidationException(param);
        }
    }

    public String formatParameterName(String param) {
        return StringUtils.capitalize(param.toLowerCase());
    }


}
