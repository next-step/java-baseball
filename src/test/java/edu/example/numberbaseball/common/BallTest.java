package edu.example.numberbaseball.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("야구게임에서 사용할 `Ball`에 대한 테스트")
class BallTest {
    private static final int RADIX = 10;
    private static final int START_NUMBER_FOR_BALL = 1;
    private static final int END_NUMBER_FOR_BALL = 9;
    private static final int TEST_BALL_SIZE = END_NUMBER_FOR_BALL - START_NUMBER_FOR_BALL + 1;

    @DisplayName("`Ball`의 숫자는 1~9까지 범위에서 결정된다.")
    @Test
    void generateValidBall() {
        List<Integer> expectedBallList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        List<Ball> ballList = new ArrayList<>(TEST_BALL_SIZE);
        for (int i = START_NUMBER_FOR_BALL; i <= END_NUMBER_FOR_BALL; i++) {
            ballList.add(new Ball(i));
        }
        int actualBallSize = ballList.size();
        Object[] expectedBallArr = expectedBallList.toArray();
        Object[] actualBallArr = getBallNumberList(ballList).toArray();

        assertEquals(TEST_BALL_SIZE, actualBallSize);
        assertArrayEquals(expectedBallArr, actualBallArr);
    }

    @DisplayName("`Ball`의 숫자는 1~9까지 범위에서 결정된다. `Ball`의 초기화 자료형은 char로 한다.")
    @Test
    void generateValidBallWithCharacter() {
        List<Integer> expectedBallList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        List<Ball> ballList = new ArrayList<>(TEST_BALL_SIZE);
        for (int i = START_NUMBER_FOR_BALL; i <= END_NUMBER_FOR_BALL; i++) {
            char iChar = Character.forDigit(i, RADIX);
            ballList.add(new Ball(iChar));
        }
        int actualBallSize = ballList.size();
        Object[] expectedBallArr = expectedBallList.toArray();
        Object[] actualBallArr = getBallNumberList(ballList).toArray();

        assertEquals(TEST_BALL_SIZE, actualBallSize);
        assertArrayEquals(expectedBallArr, actualBallArr);
    }

    @DisplayName("`Ball`의 숫자가 1~9까지 범위를 넘어서면 만들어지지 않는다.")
    @Test
    void generateInvalidBall() {
        int invalidBallNumber = -1;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(invalidBallNumber));
    }

    List<Integer> getBallNumberList(List<Ball> ballList) {
        List<Integer> expectedBallList = new ArrayList<>(TEST_BALL_SIZE);
        for (Ball ball : ballList) {
            int ballNumber = ball.getNumber();
            expectedBallList.add(ballNumber);
        }
        return expectedBallList;
    }
}
