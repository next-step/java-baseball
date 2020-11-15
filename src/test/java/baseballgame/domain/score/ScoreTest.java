package baseballgame.domain.score;

import baseballgame.dto.CompareResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "4:5:6", "7:8:9", "9:1:3", "8:7:2", "4:2:1", "3:6:9"}, delimiter = ':')
    @DisplayName("같은 숫자를 가진 점수를 비교하는 경우 통과 테스트")
    void compareScoreWhenGivenScoreThatIsSameNumberTest(final int first, final int second, final int third) {
        final Score computer = Score.getGivenValueScore(first, second, third);
        final Score user = Score.getGivenValueScore(first, second, third);
        final CompareResult result = computer.compare(user);

        final int strikeCount = 3;
        final int ballCount = 0;

        assertTrue(result.isPass());
        assertThat(result.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(result.getBallCount()).isEqualTo(ballCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "4:5:6", "7:8:4", "5:1:3", "8:7:2", "4:2:1", "3:6:5"}, delimiter = ':')
    @DisplayName("다른 숫자를 가진 점수를 비교하는 경우 통과 실패 테스트")
    void compareScoreWhenGivenScoreThatIsNotSameNumberTest(final int first, final int second, final int third) {
        final Score computer = Score.getGivenValueScore(first, second, third);
        final Score user = Score.getGivenValueScore(first + 1, second + 1, third + 1);
        final CompareResult result = computer.compare(user);

        assertFalse(result.isPass());
    }

    @ParameterizedTest
    @CsvSource(value = {"1:4:7", "8:2:6", "9:5:3"}, delimiter = ':')
    @DisplayName("같은 자리에 같은 값을 가진 점수를 비교하는 경우 스트라이크 테스트")
    void compareScoreWhenGivenScoreThatIsSameNumberInTheSamePlaceTest(final int first, final int second, final int third) {
        final Score computer = Score.getGivenValueScore(1, 2, 3);
        final Score user = Score.getGivenValueScore(first, second, third);

        final CompareResult result = computer.compare(user);

        final int strikeCount = 1;

        assertFalse(result.isPass());
        assertThat(result.getStrikeCount()).isEqualTo(strikeCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"7:4:1", "2:9:8", "9:3:5"}, delimiter = ':')
    @DisplayName("다른 자리에 같은 값을 가진 점수를 비교하는 경우 볼 테스트")
    void compareScoreWhenGivenScoreThatIsSameNumberInTheDifferentPlaceTest(final int first, final int second, final int third) {
        final Score computer = Score.getGivenValueScore(1, 2, 3);
        final Score user = Score.getGivenValueScore(first, second, third);

        final CompareResult result = computer.compare(user);

        final int ballCount = 1;

        assertFalse(result.isPass());
        assertThat(result.getBallCount()).isEqualTo(ballCount);
    }
}
