package customer.account.application.annotation;

import customer.account.application.validators.AgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAgeConstraint {

    String message() default "Age must be 18 or older";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}