package customer.account.application.controllers;

import customer.account.application.models.customer.Request.CreateCustomerRequestDto;
import customer.account.domain.facades.CustomerFacade;
import customer.account.domain.models.CustomerModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    final private CustomerFacade customerFacade;

    @GetMapping("/{id}")
    private CustomerModel findById(@PathVariable("id") UUID id) {
        return customerFacade.findById(id.toString());
    }

    @PostMapping()
    private CustomerModel save(@Valid @RequestBody CreateCustomerRequestDto dto) {
        return customerFacade.save(dto.getName(), dto.getSurname(), dto.getIdentityNo(), dto.getBirthDate());
    }
}
