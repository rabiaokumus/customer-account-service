package customer.account.domain.models;

import java.math.BigDecimal;

public interface AccountModel {
    String getId();

    BigDecimal getBalance();

    String getName();
}
