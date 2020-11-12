package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BallTest {

    @DisplayName("Ball 객체 정상 생성. 1-9 사이의 숫자를 입력받은 경우.")
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void create(int number) {
        Ball actual = new Ball(number, 0);

        //then
        assertThat(actual).isNotNull();
    }

    @DisplayName("Ball 객체 생성 오류. 잘못된 값을 입력받은 경우.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void create_with_wrong_number(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(value, 0))
                .withMessage("1-9 사이 값을 입력해주세요");
    }

    @DisplayName("Ball 객체 생성 오류. 잘못된 순서값을 입력받은 경우.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void create_with_wrong_order(int order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(1, order))
                .withMessage("순서값이 잘못됐습니다.");
    }

    @DisplayName("숫자와 위치를 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"5,1,1", "5,0,0", "4,1,-1"})
    void compare(int number, int order, int expected) {
        //given
        Ball computerBall = new Ball(5, 1);
        Ball userBall = new Ball(number, order);

        //when
        Matcher actual = computerBall.compare(userBall);

        //then
        assertEquals(Matcher.find(expected), actual);
    }
}
