package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameCheckerTest {
    private GameChecker gameChecker;

    @BeforeEach
    public void setup() {
        gameChecker = new GameChecker();
    }

    @Test
    @DisplayName("플레이어, 컴퓨터의 같은 자리수의 숫자가 같은 개수만큼 스트라이크 개수와 일치하는지 테스트")
    public void test_when_player_numbers_and_computer_numbers_have_same_number_and_digit() {
        //given
        BaseballNumberGroup computerNumbers = BaseballNumberGroup.of(Arrays.asList(8, 1, 5));
        BaseballNumberGroup playerNumbers = BaseballNumberGroup.of(Arrays.asList(8, 4, 5));

        //when
        GameResult gameResult = gameChecker.check(playerNumbers, computerNumbers);

        //then
        assertThat(gameResult.getNumberOfStrikes()).isEqualTo(2);
        assertThat(gameResult.getNumberOfBalls()).isEqualTo(0);

    }

    @Test
    @DisplayName("플레이어, 컴퓨터의 다른 자리수의 숫자가 같은 개수만큼 볼 개수와 일치하는지 테스트")
    public void test_when_player_numbers_and_computer_numbers_have_same_number_and_different_digit() {
        //given
        BaseballNumberGroup computerNumbers = BaseballNumberGroup.of(Arrays.asList(8, 1, 5));
        BaseballNumberGroup playerNumbers = BaseballNumberGroup.of(Arrays.asList(1, 5, 8));

        //when
        GameResult gameResult = gameChecker.check(playerNumbers, computerNumbers);

        //then
        assertThat(gameResult.getNumberOfStrikes()).isEqualTo(0);
        assertThat(gameResult.getNumberOfBalls()).isEqualTo(3);

    }

    @Test
    @DisplayName("볼 개수와 스트라이크 개수 동시 카운트가 되는지 테스트")
    public void test_count_of_balls_and_strikes() {
        //given
        BaseballNumberGroup computerNumbers = BaseballNumberGroup.of(Arrays.asList(8, 1, 5));
        BaseballNumberGroup playerNumbers = BaseballNumberGroup.of(Arrays.asList(8, 3, 1));

        //when
        GameResult gameResult = gameChecker.check(playerNumbers, computerNumbers);

        //then
        assertThat(gameResult.getNumberOfStrikes()).isEqualTo(1);
        assertThat(gameResult.getNumberOfBalls()).isEqualTo(1);

    }

    @Test
    @DisplayName("숫자를 모두 맞췄을 때 모두 스트라이크인지 테스트")
    public void test_when_numbers_are_all_strikes() {
        //given
        BaseballNumberGroup computerNumbers = BaseballNumberGroup.of(Arrays.asList(8, 1, 5));
        BaseballNumberGroup playerNumbers = BaseballNumberGroup.of(Arrays.asList(8, 1, 5));

        //when
        GameResult gameResult = gameChecker.check(playerNumbers, computerNumbers);

        //then
        assertThat(gameResult.getNumberOfStrikes()).isEqualTo(3);
        assertThat(gameResult.getNumberOfBalls()).isEqualTo(0);
        assertThat(gameResult.isAllStrikes()).isTrue();
    }

    @Test
    @DisplayName("숫자를 모두 못 맞췄을 때 낫싱 출력 테스트")
    public void test_when_numbers_are_nothing() {
        //given
        BaseballNumberGroup computerNumbers = BaseballNumberGroup.of(Arrays.asList(8, 1, 5));
        BaseballNumberGroup playerNumbers = BaseballNumberGroup.of(Arrays.asList(3, 7, 2));

        //when
        GameResult gameResult = gameChecker.check(playerNumbers, computerNumbers);

        //then
        assertThat(gameResult.getNumberOfStrikes()).isEqualTo(0);
        assertThat(gameResult.getNumberOfBalls()).isEqualTo(0);
        assertThat(gameResult.toString()).isEqualTo("낫싱");
    }

}