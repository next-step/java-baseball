package baseball.rule;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class GameManagerTest {

    private GameManager gm;

    @BeforeEach
    void setUp() {
        gm = new GameManager();
    }

    @RepeatedTest(10)
    @DisplayName("정답 생성시 1~9까지 중복없는 숫자 3개 검증하기")
    void generateAnswersValid() {
        Integer[] answers = gm.getAnswers();
        assertThat(answers.length).isEqualTo(3);

        Set<Integer> duplicateCheckSet = new HashSet<>(Arrays.asList(answers.clone()));
        assertThat(duplicateCheckSet.size()).isEqualTo(3);

        for (int answer : answers) {
            assertThat(answer).isBetween(0, 9);
        }
    }

}