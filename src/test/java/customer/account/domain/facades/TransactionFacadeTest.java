package customer.account.domain.facades;

import customer.account.application.models.transaction.Response.CreateTransactionResponseDto;
import customer.account.application.models.transaction.Response.GetTransactionDetailResponseDto;
import customer.account.application.models.transaction.Response.GetTransctionsByAccountIdResponseDto;
import customer.account.domain.facades.components.TransactionComponent;
import customer.account.domain.models.TransactionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TransactionFacadeTest {

    @Mock
    private TransactionComponent transactionComponent;

    @InjectMocks
    private TransactionFacade transactionFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        String id = "26eae71b-b8c1-4363-802c-38152d170003";
        GetTransactionDetailResponseDto expectedResponse = new GetTransactionDetailResponseDto();
        when(transactionComponent.findById(id)).thenReturn(expectedResponse);

        GetTransactionDetailResponseDto result = transactionFacade.findById(id);

        assertEquals(expectedResponse, result);
        verify(transactionComponent, times(1)).findById(id);
    }

    @Test
    void testFindByExternalId() {
        String externalId = "3d3917a2-5be6-49d8-9557-0e4daba219e3";
        GetTransactionDetailResponseDto expectedResponse = new GetTransactionDetailResponseDto();
        when(transactionComponent.findByExternalId(externalId)).thenReturn(expectedResponse);

        GetTransactionDetailResponseDto result = transactionFacade.findByExternalId(externalId);

        assertEquals(expectedResponse, result);
        verify(transactionComponent, times(1)).findByExternalId(externalId);
    }

    @Test
    void testFindByAccountId() {
        String accountId = "c5b93901-10c1-43d8-9c02-c48bc29ee5e0";
        GetTransctionsByAccountIdResponseDto expectedResponse = new GetTransctionsByAccountIdResponseDto();
        when(transactionComponent.findByAccountId(accountId)).thenReturn(expectedResponse);

        GetTransctionsByAccountIdResponseDto result = transactionFacade.findByAccountId(accountId);

        assertEquals(expectedResponse, result);
        verify(transactionComponent, times(1)).findByAccountId(accountId);
    }

    @Test
    void testSave() {
        String accountId = "c5b93901-10c1-43d8-9c02-c48bc29ee5e0";
        BigDecimal amount = BigDecimal.valueOf(100.50);
        String externalId = "0a199344-a620-457a-92ae-c86bf3c19c92";
        Integer direction = 1;
        CreateTransactionResponseDto expectedTransaction = new CreateTransactionResponseDto();
        when(transactionComponent.save(accountId, amount, externalId, direction)).thenReturn(expectedTransaction);

        TransactionModel result = transactionFacade.save(accountId, amount, externalId, direction);

        assertEquals(expectedTransaction, result);
        verify(transactionComponent, times(1)).save(accountId, amount, externalId, direction);
    }
}
