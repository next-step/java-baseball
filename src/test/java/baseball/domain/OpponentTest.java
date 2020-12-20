package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class OpponentTest {
    @DisplayName("NumberGenerateStrategy가 주어지면 그에 따라 BallNumbers를 생성한다")
    @Test
    void generateBallNumbers() {
        Opponent opponent = new Opponent(new OneTwoThreeGenerator());
        BallNumbers result = opponent.generateBallNumbers();

        assertThat(result.getNumbers())
                .extracting(BallNumber::getNumber)
                .isEqualTo(Arrays.asList(1, 2, 3));
    }
}