import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoChoiceStrategyTest {

    @DisplayName("랜덤 숫자 생성 테스트")
    @Test
    void validGenerate() {
        Numbers expected = Numbers.valueOf(1,2,3);

        AutoChoiceStrategy autoChoiceStrategy = new AutoChoiceStrategy() {
            @Override
            public Numbers generate() {
                return expected;
            }
        };
        Numbers result = autoChoiceStrategy.generate();

        assertThat(result).isEqualTo(Numbers.valueOf(1,2,3));
    }

    @DisplayName("랜덤 숫자 생성시 길이체크")
    @Test
    void validSize() {
        AutoChoiceStrategy autoChoiceStrategy = new AutoChoiceStrategy();
        Numbers result = autoChoiceStrategy.generate();
        List<Number> numbers = result.getNumbers();

        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("랜덤 숫자 생성시 1~9 사이 안에 있는지 확인")
    @ParameterizedTest
    @ValueSource (ints = {0, -1, 10, 100})
    void validRange(int disexpected) {
        AutoChoiceStrategy autoChoiceStrategy = new AutoChoiceStrategy();
        Numbers result = autoChoiceStrategy.generate();
        List<Number> numbers = result.getNumbers();
        List<Integer> intNumbers = new ArrayList<>(); //Number객체 유효성 회피목적
        for (Number number : numbers) {
            intNumbers.add(number.getNumber());
        }
        assertThat(intNumbers).doesNotContain(disexpected);
    }
}