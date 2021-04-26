package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EndTypeTest {

    @DisplayName("종료 타입 문자를 입력하면 해당하는 종료 타입을 반환한다")
    @Test
    void findEndType() {
        // given
        String reRunTypeString = "1";
        String systemExitTypeString = "2";

        // when
        EndType reRunType = EndType.findEndType(reRunTypeString);
        EndType systemExitType = EndType.findEndType(systemExitTypeString);

        // then
        assertThat(reRunType).isEqualTo(EndType.RE_RUN);
        assertThat(systemExitType).isEqualTo(EndType.SYSTEM_EXIT);
    }

    @DisplayName("유효하지않은 종료 타입을 입력하면 예외가 발생한다")
    @Test
    void invalid_type_exception() {
        assertThatThrownBy(() -> EndType.findEndType("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 종료타입 입니다.");
    }
}
