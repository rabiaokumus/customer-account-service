package customer.account.application.annotation;

import customer.account.application.validators.ValueOfEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {
    String message() default "Value must be 0 or 1";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}



