package customer.account.domain.facades;

import customer.account.application.models.account.Response.CreateCustomerAccountResponseDto;
import customer.account.application.models.account.Response.GetAccountDetailResponseDto;
import customer.account.application.models.account.Response.GetCustomerAccountsResponseDto;
import customer.account.domain.facades.components.AccountComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountComponent accountComponent;

    public CreateCustomerAccountResponseDto save(String customerId, String name, BigDecimal amount, Integer initialCredit) {
        // TODO add control initialCredit for to save transaction
        if (initialCredit == 1)
            return accountComponent.save(customerId, name, amount);

        return null;
    }

    public GetAccountDetailResponseDto findById(String id) {
        return accountComponent.findById(id);
    }

    public GetCustomerAccountsResponseDto findByCustomerId(String customerId) {
        return accountComponent.findByCustomerId(customerId);
    }

    public boolean isExist(String id) {
        return accountComponent.isAccountExist(id);
    }
}

