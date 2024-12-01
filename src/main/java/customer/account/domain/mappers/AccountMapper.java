package customer.account.domain.mappers;

import customer.account.application.models.account.Response.CreateCustomerAccountResponseDto;
import customer.account.application.models.account.Response.GetAccountDetailResponseDto;
import customer.account.application.models.account.Response.GetCustomerAccountsResponseDto;
import customer.account.infra.mysql.entity.AccountEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AccountMapper {
    public static CreateCustomerAccountResponseDto toCreateUserAccountResponse(AccountEntity entity) {
        return CreateCustomerAccountResponseDto.builder()
                .id(entity.getId())
                .balance(entity.getBalance())
                .name(entity.getName())
                .build();
    }

    public static GetAccountDetailResponseDto toGetAccountDetailResponse(AccountEntity entity){
        return GetAccountDetailResponseDto.builder()
                .id(entity.getId())
                .balance(entity.getBalance())
                .name(entity.getName())
                .build();
    }

    public static GetCustomerAccountsResponseDto toGetCustomerAccountsResponse(ArrayList<AccountEntity> list){
        return GetCustomerAccountsResponseDto.builder()
                .ids(list.stream()
                        .map(e -> e.getId())
                        .collect(Collectors.toList()))
                .build();
    }
}

