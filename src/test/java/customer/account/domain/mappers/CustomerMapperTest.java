package customer.account.domain.mappers;

import customer.account.domain.models.CustomerModel;
import customer.account.infra.mysql.entity.CustomerEntity;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerMapperTest {
    @Test
    void testToCreateCustomerResponse() {
        CustomerEntity entity = new CustomerEntity();
        entity.setId("cf9e6228-f130-4d63-a0e8-0c6918f4e5c3");

        CustomerModel response = CustomerMapper.toCreateCustomerResponse(entity);

        assertEquals("cf9e6228-f130-4d63-a0e8-0c6918f4e5c3", response.getId());
    }

    @Test
    void testToGetCustomerDetailResponse() {
        CustomerEntity entity = new CustomerEntity();
        entity.setId("ceec9c82-8e25-409c-b831-71b20426870d");
        entity.setName("Rabia");
        entity.setSurname("Okumus");
        entity.setIdentityNo("123456789");
        entity.setBirthDate(LocalDate.of(1993, 1, 1));

        CustomerModel response = CustomerMapper.toGetCustomerDetailResponse(entity);

        assertEquals("ceec9c82-8e25-409c-b831-71b20426870d", response.getId());
    }
}
