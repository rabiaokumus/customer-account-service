package customer.account.application.validators;

import customer.account.application.annotation.ValueOfEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, Integer> {

    @Override
    public void initialize(ValueOfEnum constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == 0 || value == 1;
    }
}
