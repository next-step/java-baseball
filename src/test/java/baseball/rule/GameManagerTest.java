package baseball.rule;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class GameManagerTest {

    private GameManager gm;

    @RepeatedTest(10)
    @DisplayName("정답 생성시 1~9까지 중복없는 숫자 3개 검증하기")
    void generateAnswersValid() {
        gm = new GameManager();
        Integer[] answers = gm.getAnswers();
        assertThat(answers.length).isEqualTo(3);

        Set<Integer> duplicateCheckSet = new HashSet<>(Arrays.asList(answers.clone()));
        assertThat(duplicateCheckSet.size()).isEqualTo(3);

        for (int answer : answers) {
            assertThat(answer).isBetween(0, 9);
        }
    }

    @Test
    void judgeCorrection() {
        gm = new GameManager(new Integer[] {4, 2, 5});

        GameResult result = gm.judge(new Integer[]{1, 2, 3});
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(0);

        result = gm.judge(new Integer[]{4, 5, 6});
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);

        result = gm.judge(new Integer[]{7, 8, 9});
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);

        result = gm.judge(new Integer[]{2, 4, 5});
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);

        result = gm.judge(new Integer[]{4, 2, 5});
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

}