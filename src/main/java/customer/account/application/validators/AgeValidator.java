package customer.account.application.validators;

import customer.account.application.annotation.ValidAgeConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<ValidAgeConstraint, LocalDate> {

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        if (birthDate == null) {
            return false; // Doğum tarihi null olamaz
        }

        // Bugün ile doğum tarihi arasındaki farkı hesapla
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return age >= 18; // 18 yaşından büyük veya eşit mi?
    }
}