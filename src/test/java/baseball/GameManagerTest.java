package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class GameManagerTest {

    @RepeatedTest(10)
    @DisplayName("정답 생성시 1~9까지 3자리 숫자인지 검증하기")
    void generateAnswersValid() {
        GameManager gm = new GameManager();
        int[] answers = gm.getAnswers();

        assertThat(answers.length).isEqualTo(3);

        for (int i = 0; i < answers.length; i++) {
            assertThat(answers[i]).isBetween(0, 9);
        }
    }

}