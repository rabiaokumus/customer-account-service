package customer.account.application.models.account.Request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserAccountDto {
    @NotBlank(message = "customerId cannot be blank")
    @Size(min = 36, max = 36, message = "customerId must be 36 characters")
    private String customerId;

    @NotNull(message = "InitialCredit cannot be null")
    @DecimalMin(value = "0.00", message = "Amount cannot be negative")
    private BigDecimal initialCredit;

    @NotNull(message = "transactionId cannot be null")
    @Size(min = 36, max = 36, message = "customerId must be 36 characters")
    private String transactionId;
}
