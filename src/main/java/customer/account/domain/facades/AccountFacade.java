package customer.account.domain.facades;

import customer.account.application.models.account.Response.CreateCustomerAccountResponseDto;
import customer.account.application.models.account.Response.GetAccountDetailResponseDto;
import customer.account.application.models.account.Response.GetCustomerAccountsResponseDto;
import customer.account.domain.facades.components.AccountComponent;
import customer.account.domain.models.enums.Direction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountComponent accountComponent;

    private final TransactionFacade transactionFacade;

    @Transactional
    public CreateCustomerAccountResponseDto save(String customerId, BigDecimal initialCredit, String transactionId) {
        final var account = accountComponent.save(customerId, initialCredit);

        if(initialCredit.compareTo(BigDecimal.valueOf(0)) > 0){
            transactionFacade.save(account.getId(), initialCredit,transactionId, Direction.IN.getValue());
        }

        CreateCustomerAccountResponseDto response = new CreateCustomerAccountResponseDto();
        response.setId(account.getId());
        response.setBalance(initialCredit);
        return response;
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

