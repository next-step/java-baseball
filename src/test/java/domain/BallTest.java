package domain;

import exception.BallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BallTest {

    @Test
    @DisplayName("Ball_생성실패_null_입력")
    void user_ball_fail_null() {

        String balls = null;

        assertThatThrownBy(
                () -> new Ball(balls)
        ).isInstanceOf(BallException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("Ball_생성실패_문자_입력")
    void user_ball_fail_string() {
        assertThatThrownBy(
                () -> new Ball("12a")
        ).isInstanceOf(BallException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("Ball_생성실패_0포함")
    void user_ball_fail_zero(){
        assertThatThrownBy(
                () -> new Ball(Arrays.asList(0,9,7))
        ).isInstanceOf(BallException.class)
                .hasMessage("1 ~ 9 까지의 숫자를 입력하세요.");
    }

    @Test
    @DisplayName("Ball_생성실패_두자리수_입력")
    void user_ball_fail_digit(){
        assertThatThrownBy(
                () -> new Ball(Arrays.asList(23,9,7))
        ).isInstanceOf(BallException.class)
                .hasMessage("1 ~ 9 까지의 숫자를 입력하세요.");
    }

    @Test
    @DisplayName("Ball_생성실패_중복숫자_입력")
    void user_ball_fail_duplicate(){
        assertThatThrownBy(
                () -> new Ball(Arrays.asList(5,1,5))
        ).isInstanceOf(BallException.class)
                .hasMessage("중복되지 않는 숫자를 입력하세요.");
    }

    @Test
    @DisplayName("Ball_생성실패_4자리_입력")
    void user_ball_fail_size() {
        assertThatThrownBy(
                () -> new Ball(Arrays.asList(1,2,3,4))
        ).isInstanceOf(BallException.class)
                .hasMessage("숫자 3개를 입력하세요.");
    }

    @Test
    @DisplayName("Ball_생성성공_String")
    void user_ball_success_str() {

        Ball ball = new Ball("123");

        assertEquals(ball.balls.size(), 3);
    }

    @Test
    @DisplayName("Ball_생성성공_List")
    void user_ball_success_list() {

        Ball ball = new Ball(Arrays.asList(3,7,4));

        assertEquals(ball.balls.size(), 3);
    }

    @Test
    @DisplayName("Ball_생성성공_Set")
    void user_ball_success_set() {

        Ball ball = new Ball(new HashSet<>(Arrays.asList(1,2,3)));

        assertEquals(ball.balls.size(), 3);
    }


}
