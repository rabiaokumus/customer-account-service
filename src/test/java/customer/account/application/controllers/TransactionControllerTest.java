package customer.account.application.controllers;

import customer.account.application.models.transaction.Response.GetTransactionDetailResponseDto;
import customer.account.application.models.transaction.Response.GetTransctionsByAccountIdResponseDto;
import customer.account.domain.facades.TransactionFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class TransactionControllerTest {

    @Mock
    private TransactionFacade transactionFacade;

    @InjectMocks
    private TransactionController transactionController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
    }

    @Test
    void testFindById() throws Exception {
        UUID transactionId = UUID.randomUUID();
        GetTransactionDetailResponseDto responseDto = mock(GetTransactionDetailResponseDto.class);
        when(transactionFacade.findById(transactionId.toString())).thenReturn(responseDto);
        when(responseDto.getId()).thenReturn(transactionId.toString());

        mockMvc.perform(get("/transaction/{id}", transactionId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(transactionId.toString()));

        verify(transactionFacade, times(1)).findById(transactionId.toString());
    }

    @Test
    void testFindByExternalId() throws Exception {
        UUID externalId = UUID.randomUUID();
        GetTransactionDetailResponseDto responseDto = mock(GetTransactionDetailResponseDto.class);
        when(transactionFacade.findByExternalId(externalId.toString())).thenReturn(responseDto);
        when(responseDto.getExternalId()).thenReturn(externalId.toString());

        mockMvc.perform(get("/transaction")
                        .param("externalId", externalId.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.externalId").value(externalId.toString()));

        verify(transactionFacade, times(1)).findByExternalId(externalId.toString());
    }

    @Test
    void testGetTransactionsByAccountId() throws Exception {
        UUID accountId = UUID.randomUUID();
        GetTransctionsByAccountIdResponseDto responseDto = mock(GetTransctionsByAccountIdResponseDto.class);
        when(transactionFacade.findByAccountId(accountId.toString())).thenReturn(responseDto);

        mockMvc.perform(get("/transaction/account/{accountId}", accountId))
                .andExpect(status().isOk());

        verify(transactionFacade, times(1)).findByAccountId(accountId.toString());
    }
}
