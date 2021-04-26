package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    private BaseballNumberFactory numberFactory;

    @BeforeEach
    void setUp() {
        numberFactory = new BaseballNumberFactory();
    }

    @Test
    @DisplayName("스트라이크")
    void strike() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defenceNumbers = new BaseballNumbers(numbersBase);
        BaseballGame baseballGame = new BaseballGame(defenceNumbers);

        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("124");
        BaseballNumbers attackNumbers = new BaseballNumbers(numbersTarget);

        // when then
        assertThat(2).isEqualTo(baseballGame.getStrikeCount(attackNumbers));
        assertThat(baseballGame.isFinish(attackNumbers)).isFalse();
    }

    @Test
    @DisplayName("볼")
    void ball() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defenceNumbers = new BaseballNumbers(numbersBase);
        BaseballGame baseballGame = new BaseballGame(defenceNumbers);

        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("352");
        BaseballNumbers attackNumbers = new BaseballNumbers(numbersTarget);

        // when then
        assertThat(2).isEqualTo(baseballGame.getBallCount(attackNumbers));
        assertThat(baseballGame.isFinish(attackNumbers)).isFalse();
    }

    @Test
    @DisplayName("스트라이크와 볼이 함께 존재")
    void strikeAndBall() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defenceNumbers = new BaseballNumbers(numbersBase);
        BaseballGame baseballGame = new BaseballGame(defenceNumbers);

        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("132");
        BaseballNumbers attackNumbers = new BaseballNumbers(numbersTarget);

        // when then
        assertThat(1).isEqualTo(baseballGame.getStrikeCount(attackNumbers));
        assertThat(2).isEqualTo(baseballGame.getBallCount(attackNumbers));
        assertThat(baseballGame.isFinish(attackNumbers)).isFalse();
    }

    @Test
    @DisplayName("3스트라이크 - 게임 종료")
    void finishGame() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defenceNumbers = new BaseballNumbers(numbersBase);
        BaseballGame baseballGame = new BaseballGame(defenceNumbers);

        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("123");
        BaseballNumbers attackNumbers = new BaseballNumbers(numbersTarget);

        // when then
        assertThat(3).isEqualTo(baseballGame.getStrikeCount(attackNumbers));
        assertThat(baseballGame.isFinish(attackNumbers)).isTrue();
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defenceNumbers = new BaseballNumbers(numbersBase);
        BaseballGame baseballGame = new BaseballGame(defenceNumbers);

        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("789");
        BaseballNumbers attackNumbers = new BaseballNumbers(numbersTarget);

        // when then
        assertThat(0).isEqualTo(baseballGame.getStrikeCount(attackNumbers));
        assertThat(0).isEqualTo(baseballGame.getBallCount(attackNumbers));
        assertThat(baseballGame.isFinish(attackNumbers)).isFalse();
        assertThat(baseballGame.isNothing(attackNumbers)).isTrue();
    }
}