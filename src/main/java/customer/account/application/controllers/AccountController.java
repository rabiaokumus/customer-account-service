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

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    final private AccountFacade accountFacade;

    @PostMapping()
    private CreateCustomerAccountResponseDto create(@Valid @RequestBody CreateUserAccountDto dto) {
        return accountFacade.save(
                dto.getCustomerId(),
                dto.getName(),
                dto.getAmount(),
                dto.getInitialCredit());
    }

    @GetMapping("/{id}")
    private GetAccountDetailResponseDto findById(@PathVariable("id") UUID id) {
        return accountFacade.findById(id.toString());
    }

    @GetMapping("/customer/{customerId}")
    private GetCustomerAccountsResponseDto getCustomerAccounts(@PathVariable UUID customerId) {
        return accountFacade.findByCustomerId(customerId.toString());
    }
}
