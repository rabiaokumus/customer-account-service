package customer.account.domain.facades;

import customer.account.application.models.account.Response.CreateCustomerAccountResponseDto;
import customer.account.application.models.account.Response.GetAccountDetailResponseDto;
import customer.account.application.models.account.Response.GetCustomerAccountsResponseDto;
import customer.account.domain.facades.components.AccountComponent;
import customer.account.domain.models.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountFacadeTest {

    @Mock
    private AccountComponent accountComponent;

    @Mock
    private TransactionFacade transactionFacade;

    @InjectMocks
    private AccountFacade accountFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave_WithInitialCredit() {
        String customerId = "06025a48-5698-4826-a1b8-0b592c05a8a2";
        BigDecimal initialCredit = BigDecimal.valueOf(100.00);
        String transactionId = "51503ae1-d707-4a88-b7b6-934798e335c1";

        CreateCustomerAccountResponseDto account = new CreateCustomerAccountResponseDto();
        account.setId("4d19f93b-4fd2-4d4a-86d3-3ae4b8fc7387");
        when(accountComponent.save(customerId, initialCredit)).thenReturn(account);

        CreateCustomerAccountResponseDto response = accountFacade.save(customerId, initialCredit, transactionId);

        assertEquals("4d19f93b-4fd2-4d4a-86d3-3ae4b8fc7387", response.getId());
        verify(accountComponent, times(1)).save(customerId, initialCredit);
        verify(transactionFacade, times(1)).save("4d19f93b-4fd2-4d4a-86d3-3ae4b8fc7387", initialCredit, transactionId, Direction.IN.getValue());
    }

    @Test
    void testSave_WithZeroInitialCredit() {
        String customerId = "ea7942f6-2034-4d2d-a268-ab29660169bf";
        BigDecimal initialCredit = BigDecimal.ZERO;
        String transactionId = "2d631879-da0e-4b26-86ce-bd73ebc03927";

        CreateCustomerAccountResponseDto account = new CreateCustomerAccountResponseDto();
        account.setId("4d19f93b-4fd2-4d4a-86d3-3ae4b8fc7387");
        when(accountComponent.save(customerId, initialCredit)).thenReturn(account);

        CreateCustomerAccountResponseDto response = accountFacade.save(customerId, initialCredit, transactionId);

        assertEquals("4d19f93b-4fd2-4d4a-86d3-3ae4b8fc7387", response.getId());
        verify(accountComponent, times(1)).save(customerId, initialCredit);
        verify(transactionFacade, never()).save(anyString(), any(BigDecimal.class), anyString(), anyInt());
    }

    @Test
    void testFindById() {
        String accountId = "50893309-f5a5-4e40-aa85-a8bf657965a9";
        GetAccountDetailResponseDto expectedResponse = new GetAccountDetailResponseDto();
        when(accountComponent.findById(accountId)).thenReturn(expectedResponse);

        GetAccountDetailResponseDto response = accountFacade.findById(accountId);

        assertEquals(expectedResponse, response);
        verify(accountComponent, times(1)).findById(accountId);
    }

    @Test
    void testFindByCustomerId() {
        String customerId = "ec445305-1ede-41f8-9edd-7750b83da0e0";
        GetCustomerAccountsResponseDto expectedResponse = new GetCustomerAccountsResponseDto();
        when(accountComponent.findByCustomerId(customerId)).thenReturn(expectedResponse);

        GetCustomerAccountsResponseDto response = accountFacade.findByCustomerId(customerId);

        assertEquals(expectedResponse, response);
        verify(accountComponent, times(1)).findByCustomerId(customerId);
    }

    @Test
    void testIsExist() {
        String accountId = "50893309-f5a5-4e40-aa85-a8bf657965a9";
        when(accountComponent.isAccountExist(accountId)).thenReturn(true);

        boolean result = accountFacade.isExist(accountId);

        assertEquals(true, result);
        verify(accountComponent, times(1)).isAccountExist(accountId);
    }
}
