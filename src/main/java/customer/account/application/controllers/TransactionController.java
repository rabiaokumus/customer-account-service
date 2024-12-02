package customer.account.application.controllers;

import customer.account.application.models.transaction.Response.GetTransactionDetailResponseDto;
import customer.account.application.models.transaction.Response.GetTransctionsByAccountIdResponseDto;
import customer.account.domain.facades.TransactionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    final private TransactionFacade transactionFacade;

    @GetMapping("/{id}")
    private GetTransactionDetailResponseDto findById(@PathVariable("id") UUID id) {
        return transactionFacade.findById(id.toString());
    }

    @GetMapping()
    private GetTransactionDetailResponseDto findByExternalId(@RequestParam("externalId") UUID externalId) {
        return transactionFacade.findByExternalId(externalId.toString());
    }
    @GetMapping("/account/{accountId}")
    private GetTransctionsByAccountIdResponseDto getTransactionsByAccountId(@PathVariable UUID accountId) {
        return transactionFacade.findByAccountId(accountId.toString());
    }
}
