package customer.account.application.models.account.Request;

import customer.account.application.annotation.ValidAgeConstraint;
import customer.account.application.annotation.ValueOfEnum;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserAccountDto {
    @NotBlank(message = "customerId cannot be blank")
    @Size(min = 36, max = 36, message = "customerId must be 36 characters")
    private String customerId;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.00", inclusive = true, message = "Amount cannot be negative")
    private BigDecimal amount;

    @NotNull(message = "initialCredit cannot be null")
    @ValueOfEnum(message = "initialCredit must be either 0 or 1")
    private Integer initialCredit;

    @Nullable()
    @Size(max = 50, message = "name must be 50 characters")
    private String name;
}
