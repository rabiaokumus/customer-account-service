package customer.account.domain.facades;

import customer.account.application.models.transaction.Response.GetTransactionDetailResponseDto;
import customer.account.application.models.transaction.Response.GetTransctionsByAccountIdResponseDto;
import customer.account.domain.facades.components.TransactionComponent;
import customer.account.domain.models.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TransactionFacade {
    private final TransactionComponent transactionComponent;

    public GetTransactionDetailResponseDto findById(String id) {
        return (GetTransactionDetailResponseDto) transactionComponent.findById(id);
    }

    public GetTransactionDetailResponseDto findByExternalId(String externalId) {
        return (GetTransactionDetailResponseDto) transactionComponent.findByExternalId(externalId);
    }

    public GetTransctionsByAccountIdResponseDto findByAccountId(String accountId) {
        return transactionComponent.findByAccountId(accountId);
    }

    public TransactionModel save(String accountId, BigDecimal amount, String externalId, Integer direction) {
        return transactionComponent.save(accountId, amount, externalId, direction);
    }
}

