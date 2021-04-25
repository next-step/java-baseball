package techcamp.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationTest {

    @DisplayName("계산 후 결과 입력")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"123", "356", "962"})
    public void calculate_getResult(String input) {
        //Given
        Calculation calculation = new Calculation();

        //When
        Answer answer = new Answer(input);
        Question question = new Question(answer.getNumbers());
        calculation.execute(question, answer);

        //Then
        assertEquals(Config.NUMBERS_LENGTH, answer.getStrikeCount(), "생성 및 입력이 동일하므로 스트라이크 수는 설정된 값과 같아야 한다.");
        assertEquals(0, answer.getBallCount(), "생성 및 입력이 동일하므로 볼 수는 0 과 같아야 한다.");
    }
}