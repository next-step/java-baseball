package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BallsTest {
    private Balls testBalls;

    @BeforeEach
    void setUp() {
        Map<Integer, Ball> balls = new HashMap<>();
        balls.put(1, new Ball(1, 0));
        balls.put(9, new Ball(9, 1));
        balls.put(2, new Ball(2, 2));
        testBalls = new Balls(balls);
    }

    @DisplayName("세자리 숫자를 받아서 Balls 객체 생성")
    @Test
    void create() {
        //given
        String values = "192";

        //when
        Balls actual = new Balls(values);

        //then
        assertThat(actual).isNotNull();
        assertEquals(testBalls, actual);
    }

    @DisplayName("객체 생성 - 잘못된 값이 들어오면 에러 발생 (숫자 중복, 잘못된 숫자 개수")
    @ParameterizedTest
    @ValueSource(strings = {"112", "1", "1234"})
    void create_exception(String values) {
        //when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(values))
                .withMessage("1부터 9 사이의 서로 다른 숫자 3개를 입력해주세요.");
    }

    @DisplayName("숫자 비교 - STRIKE 1, BALL 2")
    @Test
    void match() {
        //given
        Balls computerBalls = new Balls("129");

        //when
        Map<Status, Integer> actual = computerBalls.match(testBalls);

        //then
        Map<Status, Integer> expected = new HashMap<>();
        expected.put(Status.STRIKE, 1);
        expected.put(Status.BALL, 2);

        assertEquals(expected, actual);
    }

    @DisplayName("숫자 비교 - ALL MISS")
    @Test
    void match_miss() {
        //given
        Balls computerBalls = new Balls("746");

        //when
        Map<Status, Integer> actual = computerBalls.match(testBalls);

        //then
        Map<Status, Integer> expected = new HashMap<>();
        expected.put(Status.MISS, 3);

        assertEquals(expected, actual);
    }
}
