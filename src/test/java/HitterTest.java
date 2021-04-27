import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import player.BaseballHitter;

import java.time.temporal.ValueRange;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("타자 테스트")
public class HitterTest {

    @Test
    @DisplayName("길이3의 1~9로 이루어진 배열을 생성하는지 확인")
    void checkLengthAndRange() {
        BaseballHitter hitter = new BaseballHitter();
        List<Integer> numbers = hitter.getNumbers();
        int minimum_number = 1;
        int maximum_number = 9;
        int length = 3;

        assertEquals(numbers.size(), length);
        numbers.forEach(number -> {
            assert (ValueRange.of(minimum_number, maximum_number).isValidIntValue(number));
        });
    }

    @Test
    @DisplayName("요소들의 중복이 없는지 확인")
    void checkUnique() {
        BaseballHitter hitter = new BaseballHitter();
        List<Integer> numbers = hitter.getNumbers();

        boolean isUnique = !numbers.get(0).equals(numbers.get(1))
                || !numbers.get(0).equals(numbers.get(2))
                || !numbers.get(1).equals(numbers.get(3));
        assert (isUnique);
    }
}
