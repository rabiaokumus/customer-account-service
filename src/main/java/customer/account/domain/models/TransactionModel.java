package customer.account.domain.models;

import java.math.BigDecimal;

public interface TransactionModel {
    String getId();

    String getAccountId();

    Integer getDirection();

    BigDecimal getAmount();

    String getExternalId();
}
