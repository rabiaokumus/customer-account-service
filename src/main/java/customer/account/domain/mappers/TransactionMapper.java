package customer.account.domain.mappers;

import customer.account.application.models.transaction.Response.CreateTransactionResponseDto;
import customer.account.application.models.transaction.Response.GetTransactionDetailResponseDto;
import customer.account.application.models.transaction.Response.GetTransctionsByAccountIdResponseDto;
import customer.account.infra.mysql.entity.TransactionEntity;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionMapper {
    public static GetTransactionDetailResponseDto toGetTransactionDetailResponseDto(TransactionEntity entity) {
        return GetTransactionDetailResponseDto.builder()
                .id(entity.getId())
                .accountId(entity.getAccountId())
                .direction(entity.getDirection())
                .amount(entity.getAmount())
                .externalId(entity.getExternalId())
                .build();
    }

    public static GetTransctionsByAccountIdResponseDto toGetTransctionsByAccountIdResponseDto(Optional<ArrayList<TransactionEntity>> values) {
        GetTransctionsByAccountIdResponseDto responseDto = new GetTransctionsByAccountIdResponseDto();

        ArrayList<GetTransctionsByAccountIdResponseDto.Transaction> transactions = values
                .orElse(new ArrayList<>())
                .stream()
                .map(TransactionMapper::mapEntityToTransaction)
                .collect(Collectors.toCollection(ArrayList::new));

        responseDto.setTransactions(transactions);
        return responseDto;
    }

    private static GetTransctionsByAccountIdResponseDto.Transaction mapEntityToTransaction(TransactionEntity entity) {
        GetTransctionsByAccountIdResponseDto.Transaction transaction = new GetTransctionsByAccountIdResponseDto.Transaction();
        transaction.setId(entity.getId());
        transaction.setAccountId(entity.getAccountId());
        transaction.setExternalId(entity.getExternalId());
        transaction.setAmount(entity.getAmount());
        transaction.setDirection(entity.getDirection());
        return transaction;
    }

    public static CreateTransactionResponseDto toResponse(TransactionEntity entity) {
        CreateTransactionResponseDto transaction = new CreateTransactionResponseDto();
        transaction.setId(entity.getId());
        transaction.setAccountId(entity.getAccountId());
        transaction.setExternalId(entity.getExternalId());
        transaction.setAmount(entity.getAmount());
        transaction.setDirection(entity.getDirection());
        return transaction;
    }
}

