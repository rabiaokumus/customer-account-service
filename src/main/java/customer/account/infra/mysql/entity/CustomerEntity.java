package customer.account.infra.mysql.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customers")
@Table(name = "customers")
@SQLDelete(sql = "UPDATE notification_transaction SET deleted = true, deleted_at = now() WHERE id=?")
@SQLRestriction(BaseSoftDeleteEntity.DELETED_CLAUSE)
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, nullable = false, updatable = false)
    private String id;
}
