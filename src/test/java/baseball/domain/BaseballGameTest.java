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
        BaseballNumbers defence = new BaseballNumbers(numbersBase);
        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("124");
        BaseballNumbers pitch = new BaseballNumbers(numbersTarget);

        // when
        BaseballGame baseballGame = new BaseballGame(defence, pitch);

        // when
        assertThat(2).isEqualTo(baseballGame.getStrikeCount());
        assertThat(baseballGame.isFinish()).isFalse();
    }

    @Test
    @DisplayName("볼")
    void ball() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defence = new BaseballNumbers(numbersBase);
        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("352");
        BaseballNumbers pitch = new BaseballNumbers(numbersTarget);

        // when
        BaseballGame baseballGame = new BaseballGame(defence, pitch);

        // then
        assertThat(2).isEqualTo(baseballGame.getBallCount());
        assertThat(baseballGame.isFinish()).isFalse();
    }

    @Test
    @DisplayName("스트라이크와 볼이 함께 존재")
    void strikeAndBall() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defence = new BaseballNumbers(numbersBase);
        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("132");
        BaseballNumbers pitch = new BaseballNumbers(numbersTarget);

        // when
        BaseballGame baseballGame = new BaseballGame(defence, pitch);

        // then
        assertThat(1).isEqualTo(baseballGame.getStrikeCount());
        assertThat(2).isEqualTo(baseballGame.getBallCount());
        assertThat(baseballGame.isFinish()).isFalse();
    }

    @Test
    @DisplayName("3스트라이크 - 게임 종료")
    void finishGame() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defence = new BaseballNumbers(numbersBase);
        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("123");
        BaseballNumbers pitch = new BaseballNumbers(numbersTarget);

        // when
        BaseballGame baseballGame = new BaseballGame(defence, pitch);

        // then
        assertThat(3).isEqualTo(baseballGame.getStrikeCount());
        assertThat(baseballGame.isFinish()).isTrue();
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        // given
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers defence = new BaseballNumbers(numbersBase);
        List<BaseballNumber> numbersTarget = numberFactory.generateBaseballNumbers("789");
        BaseballNumbers pitch = new BaseballNumbers(numbersTarget);

        // then
        BaseballGame baseballGame = new BaseballGame(defence, pitch);

        // when then
        assertThat(0).isEqualTo(baseballGame.getStrikeCount());
        assertThat(0).isEqualTo(baseballGame.getBallCount());
        assertThat(baseballGame.isFinish()).isFalse();
        assertThat(baseballGame.isNothing()).isTrue();
    }
}