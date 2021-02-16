package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("BaseballNumber 생성 테스트 - 정상")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 정상_생성_테스트(int number){
        BaseballNumber baseballNumber = new BaseballNumber(number);
        assertThat(baseballNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("BaseballNumber 생성 테스트 - 비정상")
    @ParameterizedTest
    @ValueSource(ints = {0, 12, 132, 999, -5})
    void 비정상_생성_테스트(int number){
        assertThatThrownBy(() -> {
            BaseballNumber baseballNumber = new BaseballNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}