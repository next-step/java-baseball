package precourse.baseball;

import static precourse.constant.BaseballGameMessage.*;
import static precourse.constant.BaseballSpecification.*;

import java.util.Objects;

public class Baseball {

    private final int number;

    public Baseball(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_ANSWER.content());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return number == baseball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
