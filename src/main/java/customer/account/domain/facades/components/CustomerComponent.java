package customer.account.domain.facades.components;

import customer.account.domain.exceptions.NotFoundException;
import customer.account.domain.models.CustomerModel;
import customer.account.infra.mysql.entity.CustomerEntity;
import customer.account.infra.mysql.repository.CustomerRepository;
import customer.account.domain.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CustomerComponent {
    private final CustomerRepository customerRepository;

    public CustomerModel findById(String id){
        final var customerEntity = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found!"));
        return CustomerMapper.toGetCustomerDetailResponse(customerEntity);
    }

    public CustomerModel save(String name, String surname, String identityNo, LocalDate birthDate) {
        CustomerEntity customerEntity = new CustomerEntity(name, surname, identityNo, birthDate);

        final var savedEntity = customerRepository.save(customerEntity);
        return CustomerMapper.toCreateCustomerResponse(savedEntity);
    }
}
