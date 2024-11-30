package customer.account.domain.facades;

import customer.account.domain.facades.components.CustomerComponent;
import customer.account.domain.models.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CustomerFacade {
    private final CustomerComponent customerComponent;

    public CustomerModel findById(String id){
        return customerComponent.findById(id);
    }
}

