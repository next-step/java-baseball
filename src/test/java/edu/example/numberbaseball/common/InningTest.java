package edu.example.numberbaseball.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("야구게임 1회를 구성하는 정보를 가진 `Inning`에 대한 테스트")
class InningTest {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int VALID_BALL_SIZE_FOR_INNING = 3;

    @DisplayName("`Inning`은 서로 다른 숫자를 가진 3개 `Ball`을 가진다.")
    @Test
    void createValidInning() {
        List<Ball> ballList = new ArrayList<>(VALID_BALL_SIZE_FOR_INNING);
        ballList.add(new Ball(ONE));
        ballList.add(new Ball(TWO));
        ballList.add(new Ball(THREE));
        Inning inning = new Inning(ballList);

        List<Integer> ballNumberList = inning.getBallNumberList();
        int ballNumberListSize = ballNumberList.size();

        assertEquals(VALID_BALL_SIZE_FOR_INNING, ballNumberListSize);
    }

    @DisplayName("`Inning`은 3개의 `Ball`을 가지지 않으면 예외를 발생한다.")
    @Test
    void createInvalidInningWithoutThreeBalls() {
        List<Ball> ballList = new ArrayList<>(VALID_BALL_SIZE_FOR_INNING);
        ballList.add(new Ball(ONE));
        ballList.add(new Ball(TWO));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Inning(ballList));
    }

    @DisplayName("`Inning`은 3개의 `Ball` 중에서 중복되는 숫자를 가지면 예외를 발생한다.")
    @Test
    void checkInvalidInningWithDuplicatedBalls() {
        List<Ball> ballList = new ArrayList<>(VALID_BALL_SIZE_FOR_INNING);
        ballList.add(new Ball(ONE));
        ballList.add(new Ball(ONE));
        ballList.add(new Ball(TWO));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Inning(ballList));
    }

}
