package numberBaseball.service;

import numberBaseball.domain.GameNumber;
import numberBaseball.exception.NotSourceNumberException;
import numberBaseball.exception.NotThreeDigitException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseBallServiceTest {

    @Test
    void getResultResponseTest() {
        //given
        NumberBaseBallService numberBaseBallService = new NumberBaseBallService();
        numberBaseBallService.generateTargetNumber();
        assertThatThrownBy(() -> {
            // when
            numberBaseBallService.getResultResponse("abc");
        })
                // then
                .isInstanceOf(NotSourceNumberException.class)
                .hasMessageContaining("1-9 사이의 정수만 입력할 수 있습니다.");
    }
}