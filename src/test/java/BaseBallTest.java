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
        //when
        List<Integer> answer = BaseBall.makeAnswer();

        //then
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
        assertThat(game.getUserResult(answer).getIsAnswer()).isEqualTo(true);
        assertThat(game.getUserResult(answer).getStrike()).isEqualTo(3);
    }

    @DisplayName("야구게임 정답 불일치1(0스트라이크 0볼)")
    @Test
    public void testAnswerIsWrong1() {
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);

        //when
        List<Integer> notMatch = Arrays.asList(4, 5, 6);

        BaseBall game = new BaseBall(answer);

        //then
        assertThat(game.getUserResult(notMatch).getIsAnswer()).isEqualTo(false);
        assertThat(game.getUserResult(notMatch).getStrike()).isEqualTo(0);
        assertThat(game.getUserResult(notMatch).getBall()).isEqualTo(0);
    }

    @DisplayName("야구게임 정답 불일치(0스트라이크 3볼)")
    @Test
    public void testAnswerIsWrong2() {
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);

        //when
        List<Integer> ball3 = Arrays.asList(3, 1, 2);

        BaseBall game = new BaseBall(answer);

        //then
        assertThat(game.getUserResult(ball3).getIsAnswer()).isEqualTo(false);
        assertThat(game.getUserResult(ball3).getStrike()).isEqualTo(0);
        assertThat(game.getUserResult(ball3).getBall()).isEqualTo(3);
    }

    @DisplayName("야구게임 정답 불일치3(1스트라이크 2볼)")
    @Test
    public void testAnswerIsWrong3() {
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);

        //when
        List<Integer> ball2strike1 = Arrays.asList(1, 3, 2);

        BaseBall game = new BaseBall(answer);

        //then
        assertThat(game.getUserResult(ball2strike1).getIsAnswer()).isEqualTo(false);
        assertThat(game.getUserResult(ball2strike1).getStrike()).isEqualTo(1);
        assertThat(game.getUserResult(ball2strike1).getBall()).isEqualTo(2);
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
        assertThat(game.getUserResult(firstAnswer).getIsAnswer()).isEqualTo(false);
    }
}
