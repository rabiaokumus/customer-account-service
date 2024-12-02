package customer.account.domain.facades.components;

import customer.account.application.models.account.Response.CreateCustomerAccountResponseDto;
import customer.account.application.models.account.Response.GetAccountDetailResponseDto;
import customer.account.application.models.account.Response.GetCustomerAccountsResponseDto;
import customer.account.domain.exceptions.NotFoundException;
import customer.account.domain.mappers.AccountMapper;
import customer.account.infra.mysql.entity.AccountEntity;
import customer.account.infra.mysql.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class AccountComponent {
    private final AccountRepository accountRepository;

    public CreateCustomerAccountResponseDto save(String customerId, BigDecimal amount) {
        AccountEntity accountEntity = new AccountEntity(customerId, amount, new ArrayList<>());

        final var savedEntity = accountRepository.save(accountEntity);
        return AccountMapper.toCreateUserAccountResponse(savedEntity);
    }

    public GetAccountDetailResponseDto findById(String id) {
        final var accountEntity = accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found!"));
        return AccountMapper.toGetAccountDetailResponse(accountEntity);
    }

    public GetCustomerAccountsResponseDto findByCustomerId(String customerId) {
        final var accountEntities = accountRepository.findByCustomerId(customerId).orElseThrow(() -> new NotFoundException("Account not found!"));
        return AccountMapper.toGetCustomerAccountsResponse(accountEntities);
    }

    public boolean isAccountExist(String id) {
        return accountRepository.existsById(id);
    }
}
