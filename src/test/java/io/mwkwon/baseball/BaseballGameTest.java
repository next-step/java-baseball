package io.mwkwon.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
public class BaseballGameTest {

    private BaseBallGame baseBallGame;

    @BeforeEach
    void setUp() {
        baseBallGame = new BaseBallGame();
    }

    @Test
    @DisplayName("생성된 computerNumbers의 길이가 3인지 테스트")
    void computerNumbersLengthTest() {
        String computerNumbers = baseBallGame.createComputerNumbers();
        assertThat(computerNumbers.length()).isEqualTo(BaseBallGame.BALL_COUNT);
    }

    @ParameterizedTest
    @DisplayName("생성된 computerNumber가 0보다 크고 10보다 작은 수로 이루어져있는지 테스트")
    @CsvSource({"1, 9"})
    void computerNumbersRangeTest(int start, int end) {
        String computerNumbers = baseBallGame.createComputerNumbers();
        String[] computerNumbersArr = computerNumbers.split("");
        for (String number : computerNumbersArr) {
            assertThat(Integer.valueOf(number)).isBetween(start, end);
        }
    }

    @ParameterizedTest
    @DisplayName("computerNumbers, userNumbers 값이 유효하지않을때 StringIndexOutOfBoundsException 여부 되는지 테스트")
    @CsvSource(value = {"234:34", "23:345"}, delimiter = ':')
    void throwStringIndexOutOfBoundsExceptionTest(String computerNumbers, String userNumbers) {
        GameControlVO gameControlVO = new GameControlVO();
        gameControlVO.setComputerNumbers(computerNumbers);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> baseBallGame.executeGame(gameControlVO, userNumbers))
                .withMessageContaining("range: 2");
    }

    @ParameterizedTest
    @DisplayName("computerNumbers, userNumbers 값이 유효하지않을때 NullPointerException throw 여부 테스트")
    @CsvSource(value = {":234", "345:"}, delimiter = ':')
    void throwNullPointerExceptionTest(String computerNumbers, String userNumbers) {
        GameControlVO gameControlVO = new GameControlVO();
        gameControlVO.setComputerNumbers(computerNumbers);
        assertThatNullPointerException()
                .isThrownBy(() -> baseBallGame.executeGame(gameControlVO, userNumbers))
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
        GameControlVO gameControlVO = new GameControlVO();
        gameControlVO.setComputerNumbers(computerNumbers);
        baseBallGame.executeGame(gameControlVO, userNumbers);
        assertThat(gameControlVO.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(gameControlVO.getBallCount()).isEqualTo(ballCount);
    }
}
