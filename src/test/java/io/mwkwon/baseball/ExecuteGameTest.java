package io.mwkwon.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


/**
 * executeGame method 테스트 class
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public class ExecuteGameTest {

    private BaseBallGame baseBallGame;

    @BeforeEach
    void setUp() {
        baseBallGame = new BaseBallGame();
    }

    @ParameterizedTest
    @DisplayName("computerNumbers, userNumbers 값이 유효하지않을때 StringIndexOutOfBoundsException 여부 되는지 테스트")
    @CsvSource(value = {"234:34", "23:345"}, delimiter = ':')
    void throwStringIndexOutOfBoundsExceptionTest(String computerNumbers, String userNumbers) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> baseBallGame.executeGame(computerNumbers, userNumbers))
                .withMessageContaining("range: 2");
    }

    @ParameterizedTest
    @DisplayName("computerNumbers, userNumbers 값이 유효하지않을때 NullPointerException throw 여부 테스트")
    @CsvSource(value = {":234", "345:"}, delimiter = ':')
    void throwNullPointerExceptionTest(String computerNumbers, String userNumbers) {
        assertThatNullPointerException()
                .isThrownBy(() -> baseBallGame.executeGame(computerNumbers, userNumbers))
                .withMessage(null);
    }

    @ParameterizedTest
    @DisplayName("executeGame method 게임 결과 정상 반환 여부 테스트")
    @CsvSource(value = {
            "473:473:3:0"       // 3 strike
            , "473:734:0:3"     // 3 ball
            , "473:159:0:0"     // 4 ball
            , "473:172:1:0"     // 1 strike
            , "473:439:1:1"     // 1 strike 1 ball
            , "473:437:1:2"     // 1 strike 2 ball
            , "473:479:2:0"     // 2 strike
    }, delimiter = ':')
    void gameResultTest(String computerNumbers, String userNumbers, int strikeCount, int ballCount) {
        GameResult gameResult = baseBallGame.executeGame(computerNumbers, userNumbers);
        assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
    }
}
