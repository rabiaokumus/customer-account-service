package customer.account.domain.mappers;

import customer.account.application.models.transaction.Response.CreateTransactionResponseDto;
import customer.account.application.models.transaction.Response.GetTransactionDetailResponseDto;
import customer.account.application.models.transaction.Response.GetTransctionsByAccountIdResponseDto;
import customer.account.infra.mysql.entity.TransactionEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionMapperTest {
    @Test
    void testToGetTransactionDetailResponseDto() {
        TransactionEntity entity = new TransactionEntity();
        entity.setId("417776a9-7f3d-41cb-901b-d302b828f335");
        entity.setAccountId("3ce49d3d-5de5-46fb-8b25-d8ef4a0a5988");
        entity.setDirection(1);
        entity.setAmount(BigDecimal.valueOf(100.00));
        entity.setExternalId("5c569892-c396-4e01-8d32-fe0347549ee3");

        GetTransactionDetailResponseDto response = TransactionMapper.toGetTransactionDetailResponseDto(entity);

        assertEquals("417776a9-7f3d-41cb-901b-d302b828f335", response.getId());
        assertEquals("3ce49d3d-5de5-46fb-8b25-d8ef4a0a5988", response.getAccountId());
        assertEquals(1, response.getDirection());
        assertEquals(BigDecimal.valueOf(100.00), response.getAmount());
        assertEquals("5c569892-c396-4e01-8d32-fe0347549ee3", response.getExternalId());
    }

    @Test
    void testToGetTransctionsByAccountIdResponseDto() {
        TransactionEntity entity1 = new TransactionEntity();
        entity1.setId("78a6bcc1-eed8-471d-9a13-03f553fd22b6");
        entity1.setAccountId("c6564e2c-58f0-4ca4-8fb0-e45579a90eb6");
        entity1.setDirection(1);
        entity1.setAmount(BigDecimal.valueOf(100.00));
        entity1.setExternalId("e314a64c-3a6a-48be-b76f-8dc9048f2af8");

        TransactionEntity entity2 = new TransactionEntity();
        entity2.setId("3948503b-7930-41ab-91d3-a3ba1cce4479");
        entity2.setAccountId("acc-123");
        entity2.setDirection(2);
        entity2.setAmount(BigDecimal.valueOf(200.00));
        entity2.setExternalId("b46ed36b-8e9b-4488-a0ed-2d19fd3a8354");

        ArrayList<TransactionEntity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);

        Optional<ArrayList<TransactionEntity>> optionalEntities = Optional.of(entities);

        GetTransctionsByAccountIdResponseDto response = TransactionMapper.toGetTransctionsByAccountIdResponseDto(optionalEntities);

        assertEquals(2, response.getTransactions().size());
        assertEquals("78a6bcc1-eed8-471d-9a13-03f553fd22b6", response.getTransactions().get(0).getId());
        assertEquals("3948503b-7930-41ab-91d3-a3ba1cce4479", response.getTransactions().get(1).getId());
    }

    @Test
    void testToResponse() {
        TransactionEntity entity = new TransactionEntity();
        entity.setId("a24b8883-420e-4262-9124-0ed6802cd926");
        entity.setAccountId("387c0dd6-bce9-4734-a994-11e3351af0b3");
        entity.setDirection(1);
        entity.setAmount(BigDecimal.valueOf(100.00));
        entity.setExternalId("509b433e-3fc4-4887-9e40-eaf2cf9d4de1");

        CreateTransactionResponseDto response = TransactionMapper.toResponse(entity);

        assertEquals("a24b8883-420e-4262-9124-0ed6802cd926", response.getId());
        assertEquals("387c0dd6-bce9-4734-a994-11e3351af0b3", response.getAccountId());
        assertEquals(1, response.getDirection());
        assertEquals(BigDecimal.valueOf(100.00), response.getAmount());
        assertEquals("509b433e-3fc4-4887-9e40-eaf2cf9d4de1", response.getExternalId());
    }
}
