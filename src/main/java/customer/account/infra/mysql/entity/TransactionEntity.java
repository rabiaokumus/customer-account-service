package customer.account.infra.mysql.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.util.Optional;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transactions")
@Table(name = "transactions")
@SQLDelete(sql = "UPDATE transactions SET deleted = true, deleted_at = now() WHERE id=?")
@SQLRestriction(BaseSoftDeleteEntity.DELETED_CLAUSE)
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name = "account_id", length = 36, nullable = false, updatable = false)
    private String accountId;

    @Column(name = "direction", length = 1, nullable = false, updatable = false)
    private Integer direction;

    @Column(name = "amount", nullable = false, updatable = false)
    private BigDecimal amount;

    @Column(name = "external_id", length = 36, nullable = false, updatable = false)
    private String externalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AccountEntity account;

    public TransactionEntity(String accountId, Integer direction, BigDecimal amount, String externalId) {
        this.accountId = accountId;
        this.direction = direction;
        this.amount = amount;
        this.externalId = externalId;
    }
}
