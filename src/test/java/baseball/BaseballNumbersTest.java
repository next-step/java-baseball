package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("야구번호세트 테스트")
class BaseballNumbersTest {

    @DisplayName("생성 테스트 - 간단 생성")
    @Test
    void create_simple() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(1, 2, 3);
        assertThat(baseballNumbers.getBaseballNumbers()).containsExactly(new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3));
    }

    @DisplayName("생성 테스트 - 예외발생: 길이")
    @Test
    void create_simple_exception_length() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(1, 2, 3, 4));
    }

    @DisplayName("생성 테스트 - 예외발생: 중복")
    @Test
    void create_simple_exception_duplicated() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(1, 1, 2));
    }

    @DisplayName("야구번호 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,0,STRIKE", "1,1,BALL", "4,2,NOTHING"})
    void compareBaseballNumber(int number, int index, String resultType) {
        BaseballNumbers baseballNumbers = new BaseballNumbers(1, 2, 3);
        assertThat(baseballNumbers.compareBaseballNumber(new BaseballNumber(number), index)).isEqualTo(ResultType.valueOf(resultType));
    }

}
