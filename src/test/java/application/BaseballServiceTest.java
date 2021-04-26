package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Jaedoo Lee
 */
class BaseballServiceTest {

    private int input;
    private int answer;

    @BeforeEach
    public void setUp() {
        input = 123;
        answer = 132;
    }

    @Test
    public void 스트라이크_카운트_테스트() {
        //when
        int strikeCnt = getStrikeCnt(input, answer);

        //then
        assertEquals(1, strikeCnt);
        assertNotEquals(2, strikeCnt);
    }

    private int getStrikeCnt(int n, int answer) {
        int objectNumTemp = answer;
        int inputNumTemp = n;
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            strikeCnt = equalStrikeCnt(objectNumTemp, inputNumTemp, strikeCnt);
            objectNumTemp = objectNumTemp / 10;
            inputNumTemp = inputNumTemp / 10;
        }
        return strikeCnt;
    }

    private int equalStrikeCnt(int objectNumTemp, int inputNumTemp, int strikeCnt) {
        if (objectNumTemp % 10 == inputNumTemp % 10) strikeCnt++;
        return strikeCnt;
    }

    @Test
    public void 볼_카운트_테스트() {
        //when
        int ballCnt = getBallCnt(input, answer);

        //then
        assertNotEquals(1, ballCnt);
        assertEquals(2, ballCnt);

    }

    private int getBallCnt(int n, int answer) {
        int objectNumTemp = answer;
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            ballCnt = calculateBallCnt(objectNumTemp, n, i, ballCnt);
            objectNumTemp /= 10;
        }
        return ballCnt;
    }

    private int calculateBallCnt(int objectNumTemp, int inputNumTemp, int i, int ballCnt) {
        for (int j = 0; j < 3; j++) {
            ballCnt = equalBallCnt(objectNumTemp, inputNumTemp, ballCnt, i, j);
            inputNumTemp /= 10;
        }
        return ballCnt;
    }

    private int equalBallCnt(int objectNumTemp, int inputNumTemp, int ballCnt, int i, int j) {
        if (objectNumTemp % 10 == inputNumTemp % 10 && i != j) ballCnt++;
        return ballCnt;
    }
}
