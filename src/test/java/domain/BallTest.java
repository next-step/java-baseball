package domain;

import baseball.domain.Ball;
import baseball.exception.BallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    @DisplayName("Ball_생성실패_문자입력")
    void chk_fail_ball_numeric() {
        assertThatThrownBy(() ->
                new Ball("as1")
        ).isInstanceOf(BallException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("Ball_생성실패_입력길이")
    void chk_fail_ball_size() {
        assertThatThrownBy(() ->
                new Ball(Arrays.asList(1, 2, 3, 4))
        ).isInstanceOf(BallException.class)
                .hasMessageContaining("세자리의 수를 입력해주세요.");
    }

    @Test
    @DisplayName("Ball_생성실패_빈값입력")
    void chk_fail_ball_empty() {
        assertThatThrownBy(() ->
                new Ball(Arrays.asList())
        ).isInstanceOf(BallException.class)
                .hasMessageContaining("숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("Ball_생성실패_중복입력")
    void chk_fail_ball_duplicate() {
        assertThatThrownBy(() ->
                new Ball(Arrays.asList(1, 1, 2))
        ).isInstanceOf(BallException.class)
                .hasMessageContaining("중복 된 값은 입력할 수 없습니다.");
    }

}
