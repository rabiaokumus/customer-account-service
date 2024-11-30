package customer.account.domain.mappers;

import customer.account.domain.models.CustomerModel;
import customer.account.infra.mysql.entity.CustomerEntity;
import customer.account.application.models.customer.GetCustomerDetailResponse;

public abstract class CustomerMapper {
    public static CustomerModel toResponse(CustomerEntity entity){
        return GetCustomerDetailResponse.builder().id(entity.getId()).build();
    }
}
