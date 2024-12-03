package customer.account.domain.mappers;

import customer.account.application.models.account.Response.CreateCustomerAccountResponseDto;
import customer.account.application.models.account.Response.GetAccountDetailResponseDto;
import customer.account.application.models.account.Response.GetCustomerAccountsResponseDto;
import customer.account.infra.mysql.entity.AccountEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountMapperTest {

    @Test
    void testToCreateUserAccountResponse() {
        AccountEntity entity = new AccountEntity();
        entity.setId("6fd210b1-fcc1-4393-8081-4df3011ef49d");
        entity.setBalance(BigDecimal.valueOf(100.00));

        CreateCustomerAccountResponseDto response = AccountMapper.toCreateUserAccountResponse(entity);

        assertEquals("6fd210b1-fcc1-4393-8081-4df3011ef49d", response.getId());
        assertEquals(BigDecimal.valueOf(100.00), response.getBalance());
    }

    @Test
    void testToGetAccountDetailResponse() {
        AccountEntity entity = new AccountEntity();
        entity.setId("727ed2b3-8ebd-49e6-83d5-40888236291c");
        entity.setBalance(BigDecimal.valueOf(200.00));

        GetAccountDetailResponseDto response = AccountMapper.toGetAccountDetailResponse(entity);

        assertEquals("727ed2b3-8ebd-49e6-83d5-40888236291c", response.getId());
        assertEquals(BigDecimal.valueOf(200.00), response.getBalance());
    }

    @Test
    void testToGetCustomerAccountsResponse() {
        AccountEntity entity1 = new AccountEntity();
        entity1.setId("196a5478-f342-488b-af4e-66e0402cec01");

        AccountEntity entity2 = new AccountEntity();
        entity2.setId("f0044212-a57c-49b0-a647-26b849eaeb9e");

        ArrayList<AccountEntity> accountList = new ArrayList<>();
        accountList.add(entity1);
        accountList.add(entity2);

        GetCustomerAccountsResponseDto response = AccountMapper.toGetCustomerAccountsResponse(accountList);

        assertEquals(2, response.getIds().size());
        assertEquals("196a5478-f342-488b-af4e-66e0402cec01", response.getIds().get(0));
        assertEquals("f0044212-a57c-49b0-a647-26b849eaeb9e", response.getIds().get(1));
    }
}
