package customer.account.infra.mysql.repository;

import customer.account.infra.mysql.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    AccountEntity save(AccountEntity entity);

    Optional<AccountEntity> findById(String id);

    Optional<ArrayList<AccountEntity>> findByCustomerId(String customerId);

}

