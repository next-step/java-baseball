package baseballgame.domain.parser;

import baseballgame.domain.score.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoreParserTest {
    private final ScoreParser PARSER = ScoreParser.getInstance();

    @ParameterizedTest
    @ValueSource(strings = {"283", "145", "856", "123", "724"})
    @DisplayName("유효한 데이터 입력시 Score 객체 반환 확인 테스트")
    void parseScoreWhenGivenValidStringTest(final String input) {
        final Score inputScore = PARSER.parseToGameScore(input);
        Score compareScore = null;
        try {
            final int value = Integer.parseInt(input);

            final int hundredsDigit = (value / 100);
            final int tensDigit = ((value / 10) % 10);
            final int onesDigit = (value % 10);

            compareScore = Score.getGivenValueScore(hundredsDigit, tensDigit, onesDigit);

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(inputScore).isEqualTo(compareScore);
    }

    @ParameterizedTest
    @ValueSource(strings = {"19", "6", "", "2 4"})
    @DisplayName("문자열의 길이가 3보다 작은 데이터 입력시 예외 발생 테스트")
    void parseScoreWhenGivenStringSizeIsLessThanThreeTest(final String input) {
        assertThatThrownBy(() -> PARSER.parseToGameScore(input))
            .isInstanceOf(InputMismatchException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A28", "*dk", "12!", "92;", "2 4"})
    @DisplayName("숫자가 아닌 데이터 입력시 예외 발생 테스트")
    void parseScoreWhenGivenStringIsNotNumberTest(final String input) {
        assertThatThrownBy(() -> PARSER.parseToGameScore(input))
            .isInstanceOf(InputMismatchException.class);
    }
}
