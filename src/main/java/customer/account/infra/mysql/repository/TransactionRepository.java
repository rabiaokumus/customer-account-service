package customer.account.infra.mysql.repository;

import customer.account.infra.mysql.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
    Optional<TransactionEntity> findById(String id);

    Optional<TransactionEntity> findByExternalId(String id);

    Optional<ArrayList<TransactionEntity>> findByAccountId(String accountId);

    TransactionEntity save(TransactionEntity entity);
}
