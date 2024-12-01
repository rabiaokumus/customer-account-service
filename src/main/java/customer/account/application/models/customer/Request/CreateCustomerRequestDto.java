package customer.account.application.models.customer.Request;

import customer.account.application.annotation.ValidAgeConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequestDto {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    String name;

    @NotBlank(message = "Surname cannot be blank")
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    String surname;

    @NotBlank(message = "Identity number cannot be blank")
    @Size(min = 9, max = 9, message = "Identity number must be exactly 9 characters")
    @Pattern(regexp = "\\d{9}", message = "Identity number must contain only digits")
    String identityNo;

    @NotNull(message = "Birth date is required")
    @ValidAgeConstraint(message = "Customer must be at least 18 years old")
    LocalDate birthDate;
}
