package pro.sky.skyproempl.Validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pro.sky.skyproempl.Exception.ParameterValidationException;
@Component
public class ParameterValidator {
    public void checkParameter(String param) {
        if (!StringUtils.isAlpha(param)) {
            throw new ParameterValidationException(param);
        }
    }

    public String formatParameter(String param) {
        return StringUtils.capitalize(param.toLowerCase());
    }
}
