package customer.account.infra.mysql.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "accounts")
@Table(name = "accounts")
@SQLDelete(sql = "UPDATE accounts SET deleted = true, deleted_at = now() WHERE id=?")
@SQLRestriction(BaseSoftDeleteEntity.DELETED_CLAUSE)
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name = "customer_id", length = 36, nullable = false, updatable = false)
    private String customerId;

    @Column(name = "balance", nullable = false, updatable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions = new ArrayList<>();

    public AccountEntity(String customerId,  BigDecimal balance, List<TransactionEntity> transactions) {
        this.customerId = customerId;
        this.balance = balance;
        this.transactions = transactions;
    }
}
