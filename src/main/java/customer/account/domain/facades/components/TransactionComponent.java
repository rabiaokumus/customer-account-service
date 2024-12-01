package customer.account.domain.facades.components;

import customer.account.application.models.transaction.Response.GetTransctionsByAccountIdResponseDto;
import customer.account.domain.exceptions.NotFoundException;
import customer.account.domain.mappers.TransactionMapper;
import customer.account.domain.models.TransactionModel;
import customer.account.infra.mysql.entity.AccountEntity;
import customer.account.infra.mysql.entity.TransactionEntity;
import customer.account.infra.mysql.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TransactionComponent {
    private final TransactionRepository transactionRepository;

    public TransactionModel findById(String id) {
        final var transactionEntity = transactionRepository.findById(id).orElseThrow(() -> new NotFoundException("Transaction not found!"));
        return TransactionMapper.toGetTransactionDetailResponseDto(transactionEntity);
    }

    public TransactionModel findByExternalId(String externalId) {
        final var transactionEntity = transactionRepository.findByExternalId(externalId).orElseThrow(() -> new NotFoundException("Transaction not found!"));
        return TransactionMapper.toGetTransactionDetailResponseDto(transactionEntity);
    }

    public GetTransctionsByAccountIdResponseDto findByAccountId(String accountId) {
        final var transactionEntities = transactionRepository.findByAccountId(accountId);
        return TransactionMapper.toGetTransctionsByAccountIdResponseDto(transactionEntities);
    }

    public TransactionEntity save(String accountId, BigDecimal amount, String externalId, Boolean direction) {
        final var transactionEntity = transactionRepository.save(new TransactionEntity(accountId, direction, amount, externalId));
        return transactionRepository.save(transactionEntity);
    }
}


