package baseball.rule;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class GameManagerTest {

    private GameManager gm;

    @BeforeEach
    void setUp() {
        gm = new GameManager();
    }

    @RepeatedTest(10)
    @DisplayName("정답 생성시 1~9까지 3자리 숫자인지 검증하기")
    void generateAnswersValid() {
        int[] answers = gm.getAnswers();

        assertThat(answers.length).isEqualTo(3);

        for (int answer : answers) {
            assertThat(answer).isBetween(0, 9);
        }
    }

}