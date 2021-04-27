package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberGeneratorTest {
    private BaseballNumberGenerator baseballNumberGenerator;
    private static final int REPEAT_COUNT = 20;

    @BeforeEach
    public void setup() {
        baseballNumberGenerator = new BaseballNumberGenerator();
    }

    @DisplayName("생성한 야구번호가 3자리 수인지 확인")
    @RepeatedTest(value = REPEAT_COUNT, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    public void check_baseball_numbers_length_are_three_digits() {
        BaseballNumberGroup baseballNumberGroup = baseballNumberGenerator.generate();
        assertThat(baseballNumberGroup.size()).isEqualTo(3);
    }

    @DisplayName("생성한 야구번호가 1~9 범위인지 확인")
    @RepeatedTest(value = REPEAT_COUNT, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    public void check_baseball_numbers_range_are_1_to_9() {
        BaseballNumberGroup baseballNumberGroup = baseballNumberGenerator.generate();
        for (int i = 0; i < baseballNumberGroup.size(); i++) {
            assertThat(baseballNumberGroup.get(i))
                    .isGreaterThanOrEqualTo(1)
                    .isLessThanOrEqualTo(9);
        }
    }

    @DisplayName("생성한 야구번호가 서로 다른 임의의 수인지 확인")
    @RepeatedTest(value = REPEAT_COUNT, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    public void check_baseball_numbers_are_different_each_other() {
        BaseballNumberGroup baseballNumberGroup = baseballNumberGenerator.generate();
        Set<Integer> setOfBaseballNumbers = new HashSet<>();
        for (int i = 0; i < baseballNumberGroup.size(); i++) {
            setOfBaseballNumbers.add(baseballNumberGroup.get(i));
        }
        assertThat(baseballNumberGroup.size()).isEqualTo(setOfBaseballNumbers.size());
    }
}
