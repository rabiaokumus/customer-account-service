package customer.account.infra.mysql.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;


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
    @Column(name = "id", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name = "name", length = 50, nullable = false, updatable = false)
    private String name;

    @Column(name = "surname", length = 100, nullable = false, updatable = false)
    private String surname;

    @Column(name = "identity_no", length = 9, nullable = false, updatable = false)
    private String identityNo;

    @Column(name = "birth_date", nullable = false, updatable = false)
    private LocalDate birthDate;

    public CustomerEntity(String name, String surname, String identityNo, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.identityNo = identityNo;
        this.birthDate = birthDate;
    }
}
