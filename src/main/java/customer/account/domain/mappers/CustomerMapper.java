package customer.account.domain.mappers;

import customer.account.application.models.customer.Response.CreateCustomerResponse;
import customer.account.domain.models.CustomerModel;
import customer.account.infra.mysql.entity.CustomerEntity;
import customer.account.application.models.customer.Response.GetCustomerDetailResponse;

public abstract class CustomerMapper {
    public static CustomerModel toCreateCustomerResponse(CustomerEntity entity){
        return CreateCustomerResponse.builder().id(entity.getId()).build();
    }

    public static CustomerModel toGetCustomerDetailResponse(CustomerEntity entity){
        return GetCustomerDetailResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .identityNo(entity.getIdentityNo())
                .birthDate(entity.getBirthDate())
                .build();
    }
}
