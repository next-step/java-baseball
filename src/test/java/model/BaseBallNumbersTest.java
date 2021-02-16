package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallNumbersTest {

    @DisplayName("중복수가 포함된 숫자열의 검증")
    @Test
    void hasDuplicates() {
        assertThrows(IllegalArgumentException.class, () -> {
            BaseBallNumbers baseBallNumbers = BaseBallNumbers.of(
                    Arrays.asList(BallNumber.of(1),
                            BallNumber.of(1),
                            BallNumber.of(3)
                            )
            );
        });
    }

    @DisplayName("유효하지않은 숫자열 길이 검")
    @Test
    void wrongSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            BaseBallNumbers baseBallNumbers = BaseBallNumbers.of(
                    Arrays.asList(BallNumber.of(1)
                    )
            );
        });
    }
    @DisplayName("야구 카운트 검증")
    @Test
    void checkBalls() {
        BaseBallNumbers computerBalls = BaseBallNumbers.of(
                Arrays.asList(BallNumber.of(1),
                BallNumber.of(2),
                BallNumber.of(3))
        );
        BaseBallNumbers playersBalls = BaseBallNumbers.of(
                Arrays.asList(BallNumber.of(3),
                        BallNumber.of(2),
                        BallNumber.of(1))
        );
        Player player = Player.of(playersBalls);
        computerBalls.checkStrikeBall(player);

        assertThat(player.getStrike()).isEqualTo(1);
        assertThat(player.getBall()).isEqualTo(2);
    }

}