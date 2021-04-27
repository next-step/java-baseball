import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    @DisplayName("입력받은 두 숫자의 자릿수가 같은 스트라이크 count를 계산하여 맞는지 검사한다")
    void strikeTest(){
        String computerNum = "246";

        String inputNum1 = "246";
        Game game = new Game();
        assertThat(game.strike(computerNum, inputNum1)).isEqualTo(3);

        String inputNum2 = "285";
        assertThat(game.strike(computerNum, inputNum2)).isEqualTo(1);
    }

    @Test
    @DisplayName("입력받은 두 숫자중 두번째 숫자의 각 자릿수가 첫번째 수의 문자에 포함되는 경우를 더한 값이 맞는지 검사한다")
    void ball(){
        String computerNum = "123";
        String inputNum1 = "436";
        Game game = new Game();
        assertThat(game.ball(computerNum, inputNum1)).isEqualTo(1);

        String inputNum2 = "231";
        assertThat(game.ball(computerNum, inputNum2)).isEqualTo(3);
    }

    @Test
    @DisplayName("strike 와 ball count의 합계가 0인경우 true, 아닌경우 false가 반환되는지를 검사한다")
    void checkNothingTest(){
        int strikeCount = 0;
        int ballCount = 0;

        Game game = new Game();
        assertTrue(game.checkNothing(strikeCount, ballCount));

        ballCount = 1;
        assertFalse(game.checkNothing(strikeCount, ballCount));
    }

    @Test
    @DisplayName("strikeCount가 1이상인 경우 true, 아닌 경우 false를 반환하는지 검사한다")
    void checkStrikeTest(){
        Game game = new Game();

        int strikeCount1 = 1;
        assertTrue(game.checkStrike(strikeCount1));

        int strikeCount2 = 0;
        assertFalse(game.checkStrike(strikeCount2));

    }

    @Test
    @DisplayName("ballCount가 1이상인 경우 true, 아닌 경우 false를 반환하는지 검사한다")
    void checkBallTest(){
        Game game = new Game();

        int ballCount1 = 1;
        assertTrue(game.checkBall(ballCount1));

        int ballCount2 = 0;
        assertFalse(game.checkStrike(ballCount2));
    }

    @ParameterizedTest
    @CsvSource({"1,0,1 스트라이크", "2,1,2 스트라이크 1 볼", "0,0,낫싱"})
    @DisplayName("strike count와 ball count에 따라 반환되는 메세지가 맞는지 검사한다")
    void setResultMsgNothingTest(Integer strikeCount, Integer ballCount, String expected){
        Game game = new Game();
        assertThat(game.setResultMsg(strikeCount, ballCount)).hasToString(expected);
    }
}

