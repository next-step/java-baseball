package baseball.domain;

import baseball.exception.BaseballNumbersHasDuplicationException;
import baseball.exception.BaseballNumbersHasInvalidLength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("야구게임 숫자 모음 테스트")
class BaseballNumbersTest {

    @ParameterizedTest(name = "중복되지 않은 3자리 야구게임 숫자 모음 생성 테스트")
    @CsvSource({
            "1, 9, 7"
            , "2, 8, 1"
    })
    void 중복되지_않은_3자리_야구게임_숫자_모음_생성_테스트(int input1, int input2, int input3) {
        // given
        List<BaseballNumber> inputValues = Arrays.asList(new BaseballNumber(input1), new BaseballNumber(input2), new BaseballNumber(input3));

        // when
        BaseballNumbers baseballNumbers = new BaseballNumbers(inputValues);

        // then
        assertThat(baseballNumbers.getSize()).isEqualTo(3);
        assertThat(baseballNumbers.getValue()).containsAll((Iterable<? extends BaseballNumber>) inputValues);
    }

    @ParameterizedTest(name = "중복 존재시 예외발생 테스트")
    @CsvSource({
            "9, 9, 7"
            , "2, 8, 2"
    })
    void 중복_존재시_예외발생_테스트(int input1, int input2, int input3) {
        // given
        List<BaseballNumber> inputValues = Arrays.asList(new BaseballNumber(input1), new BaseballNumber(input2), new BaseballNumber(input3));

        // when + then
        assertThatThrownBy(() -> new BaseballNumbers(inputValues)).isInstanceOf(BaseballNumbersHasDuplicationException.class);
    }

    @ParameterizedTest(name = "3자리가 아닌 야구게임 숫자 입력시 예외발생 테스트")
    @CsvSource({
            "1, 2, 3, 4"
    })
    void 중복_존재시_예외발생_테스트(int input1, int input2, int input3, int input4) {
        // given
        List<BaseballNumber> inputValues1 = Arrays.asList(new BaseballNumber(input1), new BaseballNumber(input2));
        List<BaseballNumber> inputValues2 = Arrays.asList(new BaseballNumber(input1), new BaseballNumber(input2), new BaseballNumber(input3), new BaseballNumber(input4));

        // when + then
        assertThatThrownBy(() -> new BaseballNumbers(inputValues1)).isInstanceOf(BaseballNumbersHasInvalidLength.class);
        assertThatThrownBy(() -> new BaseballNumbers(inputValues2)).isInstanceOf(BaseballNumbersHasInvalidLength.class);
    }

    @DisplayName("중복되지 않은 3자리 야구게임 숫자 모음 생성 테스트")
    @Test
    void 중복되지_않은_3자리_야구게임_숫자_모음_생성_테스트() {
        // when
        BaseballNumbers baseballNumbers = new BaseballNumbers("197");

        // then
        assertThat(baseballNumbers.getSize()).isEqualTo(3);
        assertThat(baseballNumbers.getValue()).containsExactly((BaseballNumber) Arrays.asList(1, 9, 7));
    }

}