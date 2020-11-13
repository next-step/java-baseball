package application;

import domain.BaseballNumbers;
import domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author : byungkyu
 * @date : 2020/11/13
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BaseballServiceTest {

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = "543")
    @DisplayName("3.2.1.상대방(컴퓨터)이_점수를_올바르게_체크했는지_점수로_확인_3_스트라이크")
    void checkBaseballNumberTestWithAllStrike(String playerBaseballNumber) {
        String customAnswer = "543";

        BaseballNumbers customBaseballAnswer = new BaseballNumbers(customAnswer);
        BaseballService baseballService = new BaseballService();
        Score score = baseballService.checkBaseballNumber(playerBaseballNumber, customBaseballAnswer);

        assertTrue(score.isAllStrike());
    }

    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = "543")
    @DisplayName("3.2.2.상대방(컴퓨터)이_점수를_올바르게_체크했는지_점수로_확인_2_스트라이크")
    void checkBaseballNumberTestWithTwoStrike(String playerBaseballNumber) {
        String customAnswer = "541";

        BaseballNumbers customBaseballAnswer = new BaseballNumbers(customAnswer);
        BaseballService baseballService = new BaseballService();
        Score score = baseballService.checkBaseballNumber(playerBaseballNumber, customBaseballAnswer);

        assertEquals(score.getStrike(), 2);
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = "543")
    @DisplayName("3.2.3.상대방(컴퓨터)이_점수를_올바르게_체크했는지_점수로_확인_1_스트라이크_2볼")
    void checkBaseballNumberTestWithOneStrikeTwoBall(String playerBaseballNumber) {
        String customAnswer = "534";

        BaseballNumbers customBaseballAnswer = new BaseballNumbers(customAnswer);
        BaseballService baseballService = new BaseballService();
        Score score = baseballService.checkBaseballNumber(playerBaseballNumber, customBaseballAnswer);

        assertEquals(score.getStrike(), 1);
        assertEquals(score.getBall(), 2);
    }

    @Order(4)
    @ParameterizedTest
    @ValueSource(strings = "543")
    @DisplayName("3.2.4.상대방(컴퓨터)이_점수를_올바르게_체크했는지_점수로_확인_1_스트라이크_1볼")
    void checkBaseballNumberTestWithOneStrikeOneBall(String playerBaseballNumber) {
        String customAnswer = "536";

        BaseballNumbers customBaseballAnswer = new BaseballNumbers(customAnswer);
        BaseballService baseballService = new BaseballService();
        Score score = baseballService.checkBaseballNumber(playerBaseballNumber, customBaseballAnswer);

        assertEquals(score.getStrike(), 1);
        assertEquals(score.getBall(), 1);
    }

    @Order(5)
    @ParameterizedTest
    @ValueSource(strings = "543")
    @DisplayName("3.2.5.상대방(컴퓨터)이_점수를_올바르게_체크했는지_점수로_확인_3볼")
    void checkBaseballNumberTestWithThreeBall(String playerBaseballNumber) {
        String customAnswer = "354";

        BaseballNumbers customBaseballAnswer = new BaseballNumbers(customAnswer);
        BaseballService baseballService = new BaseballService();
        Score score = baseballService.checkBaseballNumber(playerBaseballNumber, customBaseballAnswer);

        assertEquals(score.getBall(), 3);
    }

    @Order(6)
    @ParameterizedTest
    @ValueSource(strings = "543")
    @DisplayName("3.2.6.상대방(컴퓨터)이_점수를_올바르게_체크했는지_점수로_확인_2볼")
    void checkBaseballNumberTestWithTwoBall(String playerBaseballNumber) {
        String customAnswer = "134";

        BaseballNumbers customBaseballAnswer = new BaseballNumbers(customAnswer);
        BaseballService baseballService = new BaseballService();
        Score score = baseballService.checkBaseballNumber(playerBaseballNumber, customBaseballAnswer);

        assertEquals(score.getBall(), 2);
    }

    @Order(7)
    @ParameterizedTest
    @ValueSource(strings = "543")
    @DisplayName("3.2.7.상대방(컴퓨터)이_점수를_올바르게_체크했는지_점수로_확인_1볼")
    void checkBaseballNumberTestWithOneBall(String playerBaseballNumber) {
        String customAnswer = "124";

        BaseballNumbers customBaseballAnswer = new BaseballNumbers(customAnswer);
        BaseballService baseballService = new BaseballService();
        Score score = baseballService.checkBaseballNumber(playerBaseballNumber, customBaseballAnswer);

        assertEquals(score.getBall(), 1);
    }

}