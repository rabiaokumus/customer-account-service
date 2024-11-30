package customer.account.application.controllers;

import customer.account.domain.facades.CustomerFacade;
import customer.account.domain.models.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    final private CustomerFacade customerFacade;

    @GetMapping("/{id}")
    private CustomerModel findById(@PathVariable("id") UUID id) {
        return customerFacade.findById(id.toString());
    }
}
