
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BaseballGameTests {
    private BaseballGame game;
    private final int ORIGIN = 789;

    @BeforeEach
    void init() {
        game = new BaseballGame();
        game.setNumber(ORIGIN);
    }

    @Test
    void randomTest() {
        game.setRandomNumber();
        assertThat(100 <= game.getNumber() && game.getNumber() <= 999)
                .isTrue();
    }

    @Test
    void matchingTest() {
        int src = ORIGIN / 10 * 10 + ORIGIN % 10 * 100;
        assertThat(game.matching(ORIGIN)).isTrue();
        assertThat(game.matching(src)).isFalse();
    }

    @Test
    void getResultThreeStrikeTest(){
        String dest = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
        assertThat(game.getResult(3,0))
                .isEqualTo(dest);
    }

    @Test
    void getScoreThreeStrikeTest(){
        String dest = "3 스트라이크 ";
        assertThat(game.getScore(3,0))
                .isEqualTo(dest);
    }

    @Test
    void getScoreTwoStrikeOneBallTest(){
        String dest = "2 스트라이크 1 볼";
        assertThat(game.getScore(2,1))
                .isEqualTo(dest);
    }

    @Test
    void getResultTwoStrikeOneBallTest(){
        String dest = "2 스트라이크 1 볼";
        assertThat(game.getResult(2,1))
                .isEqualTo(dest);
    }

    @Test
    void getResultNothingTest(){
        String dest = "낫싱";
        assertThat(game.getResult(0,0))
                .isEqualTo(dest);
    }
}
