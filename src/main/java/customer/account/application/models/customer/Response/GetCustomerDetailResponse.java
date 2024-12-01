package customer.account.application.models.customer.Response;

import customer.account.domain.models.CustomerModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerDetailResponse implements CustomerModel {
    private String id;
    private String name;
    private String surname;
    private String identityNo;
    private LocalDate birthDate;
}
