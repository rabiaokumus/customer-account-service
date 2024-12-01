package customer.account.application.models.account.Response;

import customer.account.domain.models.AccountModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerAccountResponseDto implements AccountModel {
    private String id;

    private  BigDecimal balance;

    private String name;
}
