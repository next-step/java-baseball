package baseball.domain;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.domain.BallNumber.MAX_VALID_NUMBER;
import static baseball.domain.BallNumber.MIN_VALID_NUMBER;
import static baseball.domain.BallNumbers.BALL_NUMBERS_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RandomBallNumberGeneratorTest {
    @DisplayName("1~9 사이의 3개의 랜덤한 숫자를 생성하는지 확인한다")
    @Test
    void generate() {
        RandomBallNumberGenerator randomNumberGenerator = new RandomBallNumberGenerator();
        List<Integer> results = randomNumberGenerator.generate();

        Condition<Integer> lessThanMin = new Condition<>(it -> it < MIN_VALID_NUMBER, "less than 1");
        Condition<Integer> moreThanMax = new Condition<>(it -> it > MAX_VALID_NUMBER, "more than 9");
        assertAll(
                () -> assertThat(results).doNotHave(lessThanMin),
                () -> assertThat(results).doNotHave(moreThanMax),
                () -> assertThat(results).hasSize(BALL_NUMBERS_LENGTH)
        );
    }
}