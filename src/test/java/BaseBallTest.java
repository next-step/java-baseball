import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {
    @DisplayName("야구게임 정답 난수 생성")
    @Test
    public void testMakeRandomAnswer() {
        List<Integer> answer = BaseBall.makeAnswer();
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.size()).isEqualTo(new HashSet<>(answer).size());
    }

    @DisplayName("야구게임 정답 일치")
    @Test
    public void testAnswerIsCorrect() {
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);

        //when
        BaseBall game = new BaseBall(answer);

        //then
        assertThat(game.isAnswer(answer)).isEqualTo(true);
    }

    @DisplayName("야구게임 정답 불일치")
    @Test
    public void testAnswerIsWrong() {
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);

        //when
        List<Integer> notMatch = Arrays.asList(4, 5, 6);
        List<Integer> ball3 = Arrays.asList(3, 1, 2);
        List<Integer> ball2strike1 = Arrays.asList(1, 3, 2);

        BaseBall game = new BaseBall(answer);
        
        //then
        assertThat(game.isAnswer(notMatch)).isEqualTo(false);
        assertThat(game.isAnswer(ball3)).isEqualTo(false);
        assertThat(game.isAnswer(ball2strike1)).isEqualTo(false);
    }

    @DisplayName("야구게임 재시작 시 새로운 정답 생성")
    @Test
    public void testFinish() {
        //given
        List<Integer> firstAnswer = Arrays.asList(0, 0, 0);

        //when
        BaseBall game = new BaseBall(firstAnswer);

        //then
        game.finish(false);
        assertThat(game.isAnswer(firstAnswer)).isEqualTo(false);
    }
}
