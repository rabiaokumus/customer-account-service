package customer.account.application.models.transaction.Response;

import customer.account.domain.models.TransactionModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetTransactionDetailResponseDto implements TransactionModel {
    private String id;

    private String accountId;

    private String externalId;

    private BigDecimal amount;

    private Integer direction;

}


