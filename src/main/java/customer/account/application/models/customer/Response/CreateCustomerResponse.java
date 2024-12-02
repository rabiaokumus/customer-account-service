package customer.account.application.models.customer.Response;

import customer.account.domain.models.CustomerModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResponse implements CustomerModel {
    private String id;
}
