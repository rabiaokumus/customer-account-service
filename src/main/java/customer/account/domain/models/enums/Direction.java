package customer.account.domain.models.enums;

import lombok.Getter;
@Getter
public enum Direction {
    IN(0),
    OUT(1);
    final private int value;

    Direction(int value) {
        this.value = value;
    }
}
