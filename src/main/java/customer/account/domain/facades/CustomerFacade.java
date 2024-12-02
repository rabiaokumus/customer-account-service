package customer.account.domain.facades;

import customer.account.domain.facades.components.CustomerComponent;
import customer.account.domain.models.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@RequiredArgsConstructor
public class CustomerFacade {
    private final CustomerComponent customerComponent;

    public CustomerModel findById(String id) {
        return customerComponent.findById(id);
    }

    public boolean isExist(String id) {
        return customerComponent.isCustomerExist(id);
    }

    public CustomerModel save(String name, String surname, String identityNo, LocalDate birthDate) {
        return customerComponent.save(name, surname, identityNo, birthDate);
    }
}

