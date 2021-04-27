package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ContinueOptionsTest {

    @Test
    @DisplayName("enum에 포함된 option 값 조회시 정상적으로 조회 되는지 확인.")
    void getOptionEnum() {
        ContinueOptions option = ContinueOptions.CONTINUE;

        assertThat(ContinueOptions.getOptionEnum(option.getOption()))
            .isEqualTo(option);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "9"})
    @DisplayName("enum에 포함되지 않는 값 조회시 UNKNOW 조회 되는지 확인.")
    void getOptionEnum_unknow(String input) {
        assertThat(ContinueOptions.getOptionEnum(input))
            .isEqualTo(ContinueOptions.UNKNOW);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("enum에 null이나 빈 값 조회시 UNKNOW 조회 되는지 확인.")
    void getOptionEnum_null(String input) {
        assertThat(ContinueOptions.getOptionEnum(input))
            .isEqualTo(ContinueOptions.UNKNOW);
    }
}
