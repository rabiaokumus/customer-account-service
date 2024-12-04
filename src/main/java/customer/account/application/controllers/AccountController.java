package customer.account.application.controllers;

import customer.account.application.models.account.Request.CreateUserAccountDto;
import customer.account.application.models.account.Response.CreateCustomerAccountResponseDto;
import customer.account.application.models.account.Response.GetAccountDetailResponseDto;
import customer.account.application.models.account.Response.GetCustomerAccountsResponseDto;
import customer.account.domain.facades.AccountFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    final private AccountFacade accountFacade;

    @PostMapping()
    private CreateCustomerAccountResponseDto create(@Valid @RequestBody CreateUserAccountDto dto) {
        return accountFacade.save(dto.getCustomerId(), dto.getInitialCredit(), dto.getTransactionId());
    }

    @GetMapping("/{id}")
    private GetAccountDetailResponseDto findById(@PathVariable("id") UUID id) {
        return accountFacade.findById(id.toString());
    }

    @GetMapping("/customer/{customerId}")
    private GetCustomerAccountsResponseDto getCustomerAccounts(@PathVariable("customerId") UUID customerId) {
        return accountFacade.findByCustomerId(customerId.toString());
    }
}
