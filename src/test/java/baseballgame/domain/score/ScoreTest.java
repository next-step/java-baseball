package baseballgame.domain.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    @DisplayName("아무런 파라미터를 넘겨주지 않을 때 유효한 값을 가진 객체 생성 테스트")
    void createRandomScoreInstanceTest() {
        final Score score = Score.getRandomScore();

        assertNotNull(score);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "4:5:6", "7:8:9", "9:1:3", "8:7:2", "4:2:1", "3:6:9"}, delimiter = ':')
    @DisplayName("유효한 값을 넘겨줄 때 객체 생성 테스트")
    void createGivenValueScoreInstanceWhenGivenValidValueTest(final int first, final int second, final int third) {
        final Score score = Score.getGivenValueScore(first, second, third);

        final int hundredsScore = score.getHundredsPlace();
        final int tensScore = score.getTensPlace();
        final int onesScore = score.getOnesPlace();

        assertNotNull(score);

        assertEquals(first, hundredsScore);
        assertEquals(second, tensScore);
        assertEquals(third, onesScore);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:2:3", "2:10:3", "2:3:10"}, delimiter = ':')
    @DisplayName("각 자리의 9보다 큰 값을 넘겨줄 때 예외 확인 테스트")
    void createGivenValueScoreInstanceWhenGivenValueThatIsGreaterThanNineTest(final int first, final int second, final int third) {
        assertThatThrownBy(() -> Score.getGivenValueScore(first, second, third))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1:2", "1:0:2", "1:2:0"}, delimiter = ':')
    @DisplayName("각 자리의 1보다 작은 값을 넘겨줄 때 예외 확인 테스트")
    void createGivenValueScoreInstanceWhenGivenValueThatIsLessThanZeroTest(final int first, final int second, final int third) {
        assertThatThrownBy(() -> Score.getGivenValueScore(first, second, third))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {7})
    @DisplayName("각 자리의 값이 같은 값을 넘겨줄 때 예외 확인 테스트")
    void createGivenValueScoreInstanceWhenGivenSameValueEachDigitTest(final int sameValue) {
        assertThatThrownBy(() -> Score.getGivenValueScore(sameValue, sameValue, sameValue))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
