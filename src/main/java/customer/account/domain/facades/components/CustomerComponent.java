package customer.account.domain.facades.components;

import customer.account.domain.exceptions.NotFoundException;
import customer.account.domain.models.CustomerModel;
import customer.account.infra.mysql.repository.CustomerRepository;
import customer.account.domain.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerComponent {
    private final CustomerRepository customerRepository;

    public CustomerModel findById(String id){
        final var customerEntity = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found!"));
        return CustomerMapper.toResponse(customerEntity);
    }
}
