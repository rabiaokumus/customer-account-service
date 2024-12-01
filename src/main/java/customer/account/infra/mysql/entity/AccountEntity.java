package customer.account.infra.mysql.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "accounts")
@Table(name = "accounts")
@SQLDelete(sql = "UPDATE notification_transaction SET deleted = true, deleted_at = now() WHERE id=?")
@SQLRestriction(BaseSoftDeleteEntity.DELETED_CLAUSE)
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name="customer_id", length = 50, nullable = false, updatable = false)
    private String customerId;

    @Column(name = "balance", length = 100, nullable = false, updatable = false)
    private BigDecimal balance;

    @Column(name = "name", length = 50, nullable = false, updatable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CustomerEntity customer;

    public AccountEntity(String customerId, String name, BigDecimal balance) {
        this.customerId = customerId;
        this.balance = balance;
        this.name = name;
    }
}
