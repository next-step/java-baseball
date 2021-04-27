package baseball.domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static baseball.domain.core.BaseballNo.ERROR_MESSAGE_UNEXPECTED_RANGE_NO;
import static baseball.domain.core.BaseballNo.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("야구 게임 숫자 제한(1~9) 테스트")
class BaseballNoTest {

    @DisplayName("야구게임에 표시 가능한 숫자는 1~9까지 숫자 이외에는 예외 발생함")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void unexpectedRange(int no) {
        assertThatIllegalArgumentException()
            .isThrownBy(()-> valueOf(no))
            .withMessage(ERROR_MESSAGE_UNEXPECTED_RANGE_NO);
    }

    @DisplayName("야구게임의 숫자는 1 ~ 9까지로 단일 객체임")
    @RepeatedTest(9)
    void singleton(RepetitionInfo repetitionInfo) {
        assertThat(valueOf(repetitionInfo.getCurrentRepetition()))
            .isSameAs(valueOf(repetitionInfo.getCurrentRepetition()))
        ;
    }

    @DisplayName("야구게임 숫자가 총 9개(1~9)의 랜덤한 배열 인지 확인")
    @Test
    void shuffleBaseballNosSizeCheck() {
        final int EXPECTED_SHUFFLED_MAX_BASEBALL_SIZE = 9;
        final List<BaseballNo> shuffleBaseballNos = BaseballNo.shuffleBaseballNos();
        assertThat(shuffleBaseballNos.size()).isEqualTo(EXPECTED_SHUFFLED_MAX_BASEBALL_SIZE);
    }
}