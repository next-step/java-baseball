package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("야구게임 숫자 점수계산 테스트")
class BaseballNumbersComparatorTest {

    @ParameterizedTest(name = "3스트라이크 테스트")
    @CsvSource({
            "197, 197"
            , "281, 281"
    })
    void test(String input1, String input2) {
        // given
        BaseballNumbers computerNumber = new BaseballNumbers(input1);
        BaseballNumbers playerNumber = new BaseballNumbers(input2);

        // when
        Score score = BaseballNumbersComparator.getScore(computerNumber, playerNumber);

        // then
        assertThat(score.getStrike()).isEqualTo(3);
    }
}