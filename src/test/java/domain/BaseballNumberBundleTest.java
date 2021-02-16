package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberBundleTest {

    @DisplayName("BaseballNumberBundle 생성 테스트 - 정상")
    @ParameterizedTest
    @ValueSource(ints = {123, 345, 765, 987, 765, 423})
    void 정상_생성_테스트(int number) {
        BaseballNumberBundle baseballNumberBundle = new BaseballNumberBundle(number);
        List<BaseballNumber> baseballNumbers = baseballNumberBundle.getNumberBundle();
        String[] numberString = String.valueOf(number).split("");
        for(int i = 0; i < 3; ++i){
            assertThat(Integer.parseInt(numberString[i])).isEqualTo(baseballNumbers.get(i).getNumber());
        }
    }

    @DisplayName("BaseballNumberBundle 생성 테스트 - 비정상")
    @ParameterizedTest
    @ValueSource(ints = {1234, 012, 223, 599, 502, 5, 90, 11})
    void 비정상_생성_테스트(int number) {
        assertThatThrownBy(() -> {
            BaseballNumberBundle baseballNumberBundle = new BaseballNumberBundle(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}