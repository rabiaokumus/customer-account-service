package customer.account.infra.mysql.repository;

import customer.account.infra.mysql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
    Optional<CustomerEntity> findById(String id);

    CustomerEntity save(CustomerEntity entity);
}

