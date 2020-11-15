package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @DisplayName("Numbers객체생성 테스트")
    @Test
    void create() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(Number.valueOf(1));
        numbers.add(Number.valueOf(2));
        numbers.add(Number.valueOf(3));

        Numbers results = Numbers.valueOf(numbers);
        assertThat(results.getNumbers()).isNotNull();
        assertThat(results.size()).isEqualTo(3);
        assertThat(results).isEqualTo(Numbers.valueOf(numbers));
    }

    @DisplayName("Numbers객체생성시 숫자값 개수 예외 테스트")
    @Test
    void validSize() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(Number.valueOf(1));
        numbers.add(Number.valueOf(2));
        numbers.add(Number.valueOf(3));
        numbers.add(Number.valueOf(4));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Numbers.valueOf(numbers));
        assertThat(e.getMessage()).isEqualTo("숫자값은 반드시 3개 있어야 합니다.");
    }

    @DisplayName("Numbers객체생성시 숫자값이 아예 없을 경우 예외 테스트")
    @Test
    void validNull() {
        List<Number> numbers = new ArrayList<>();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Numbers.valueOf(numbers));
        assertThat(e.getMessage()).isEqualTo("숫자값은 비어있으면 안됩니다.");
    }

    @DisplayName("Numbers객체생성시 숫자값이 다르지 않을 경우 예외발생 테스트")
    @Test
    void validRandomNumbers() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(Number.valueOf(1));
        numbers.add(Number.valueOf(1));
        numbers.add(Number.valueOf(3));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Numbers.valueOf(numbers));
        assertThat(e.getMessage()).isEqualTo("숫자야구에서는 중복되는 값이 올 수 없습니다.");
    }

    @DisplayName("숫자가 하나라도 포함되었는지 여부 체크")
    @Test
    public void test_isContain() {
        Numbers numbers = Numbers.valueOf(1,2,3);
        boolean expectedTrue = numbers.isContain(Numbers.valueOf(3,4,5));
        boolean expectedFalse = numbers.isContain(Numbers.valueOf(4,5,6));

        assertThat(expectedTrue).isTrue();
        assertThat(expectedFalse).isFalse();
    }

    @DisplayName("숫자 매치하여 결과값 리턴하는 메소드 체크")
    @Test
    public void test_match() {
        Numbers numbers = Numbers.valueOf(1,2,3);
        Result resultBall = numbers.match(Numbers.valueOf(3,4,5));
        Result resultTwoStrike = numbers.match(Numbers.valueOf(4,2,3));

        assertThat(resultBall.getBallCount()).isEqualTo(1);
        assertThat(resultTwoStrike.getStrikeCount()).isEqualTo(2);
    }
}
