package customer.account.application.controllers;

import customer.account.application.models.account.Request.CreateUserAccountDto;
import customer.account.application.models.account.Response.CreateCustomerAccountResponseDto;
import customer.account.application.models.account.Response.GetAccountDetailResponseDto;
import customer.account.application.models.account.Response.GetCustomerAccountsResponseDto;
import customer.account.domain.facades.AccountFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AccountControllerTest {

    @Mock
    private AccountFacade accountFacade;

    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test
    void testFindById() throws Exception {
        UUID accountId = UUID.randomUUID();
        GetAccountDetailResponseDto responseDto = mock(GetAccountDetailResponseDto.class);
        when(accountFacade.findById(accountId.toString())).thenReturn(responseDto);

        mockMvc.perform(get("/account/{id}", accountId))
                .andExpect(status().isOk());

        verify(accountFacade, times(1)).findById(accountId.toString());
    }

    @Test
    void testGetCustomerAccounts() throws Exception {
        UUID customerId = UUID.randomUUID();
        GetCustomerAccountsResponseDto responseDto = mock(GetCustomerAccountsResponseDto.class);
        when(accountFacade.findByCustomerId(customerId.toString())).thenReturn(responseDto);

        mockMvc.perform(get("/account/customer/{customerId}", customerId))
                .andExpect(status().isOk());

        verify(accountFacade, times(1)).findByCustomerId(customerId.toString());
    }
}

