package checkor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballCheckorTest {

    private BaseballCheckor baseballCheckor;

    @BeforeEach
    void setUp() {
        int[] numbers = new int[]{1,7,9};
        baseballCheckor = new BaseballCheckor(numbers);
    }

    @Test
    @DisplayName("숫자를 입력하면 strike 개수, ball 개수 또는 낫싱을 알려주는 테스트")
    public void check() {
    }


    @Test
    @DisplayName("strike 개수 맞추기 테스트")
    public void countStrike() {

    }
    @Test
    @DisplayName("ball 개수 맞추기 테스트")
    public void countBall() {

    }


}