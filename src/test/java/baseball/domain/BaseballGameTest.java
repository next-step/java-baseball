package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {
    private final Numbers randomNumbers = new Numbers("1", "2", "3");
    private BaseballGame baseballGame;

    @Test
    void strike3() {
        final Numbers userNumbers = new Numbers("1", "2", "3");
        baseballGame = new BaseballGame(randomNumbers, userNumbers);

        BaseballResult baseballResult = baseballGame.playOneRound();
        Map<BaseballEnum, Integer> baseballCounts = baseballResult.getBaseballCounts();

        assertThat(baseballResult.isNothing()).isFalse();
        assertThat(baseballCounts.get(BaseballEnum.STRIKE)).isEqualTo(3);
        assertThat(baseballCounts.get(BaseballEnum.BALL)).isEqualTo(0);
    }

    @Test
    void strike1ball2() {
        final Numbers userNumbers = new Numbers("1", "3", "2");
        baseballGame = new BaseballGame(randomNumbers, userNumbers);

        BaseballResult baseballResult = baseballGame.playOneRound();
        Map<BaseballEnum, Integer> baseballCounts = baseballResult.getBaseballCounts();

        assertThat(baseballResult.isNothing()).isFalse();
        assertThat(baseballCounts.get(BaseballEnum.STRIKE)).isEqualTo(1);
        assertThat(baseballCounts.get(BaseballEnum.BALL)).isEqualTo(2);
    }

    @Test
    void ball3() {
        final Numbers userNumbers = new Numbers("3", "1", "2");
        baseballGame = new BaseballGame(randomNumbers, userNumbers);

        BaseballResult baseballResult = baseballGame.playOneRound();
        Map<BaseballEnum, Integer> baseballCounts = baseballResult.getBaseballCounts();

        assertThat(baseballResult.isNothing()).isFalse();
        assertThat(baseballCounts.get(BaseballEnum.STRIKE)).isEqualTo(0);
        assertThat(baseballCounts.get(BaseballEnum.BALL)).isEqualTo(3);
    }

    @Test
    void nothing() {
        final Numbers userNumbers = new Numbers("4", "5", "6");
        baseballGame = new BaseballGame(randomNumbers, userNumbers);

        BaseballResult baseballResult = baseballGame.playOneRound();
        Map<BaseballEnum, Integer> baseballCounts = baseballResult.getBaseballCounts();

        assertThat(baseballResult.isNothing()).isTrue();
        assertThat(baseballCounts.get(BaseballEnum.STRIKE)).isEqualTo(0);
        assertThat(baseballCounts.get(BaseballEnum.BALL)).isEqualTo(0);
    }
}
