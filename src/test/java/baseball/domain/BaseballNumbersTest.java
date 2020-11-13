package baseball.domain;

import org.assertj.core.data.MapEntry;
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
        BaseballNumbers baseballNumbers = BaseballNumbers.of(1, 2, 3);
        assertThat(baseballNumbers.getBaseballNumbers()).containsExactly(new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3));
    }

    @DisplayName("생성 테스트 - 스트링 입력")
    @Test
    void create_string() {
        BaseballNumbers baseballNumbers = BaseballNumbers.ofUserInput("123");
        assertThat(baseballNumbers.getBaseballNumbers()).containsExactly(new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3));
    }

    @DisplayName("생성 테스트 - 예외발생: 길이")
    @Test
    void create_simple_exception_length() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.of(1, 2, 3, 4));
    }

    @DisplayName("생성 테스트 - 예외발생: 중복")
    @Test
    void create_simple_exception_duplicated() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballNumbers.of(1, 1, 2));
    }

    @DisplayName("야구번호 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,0,STRIKE", "1,1,BALL", "4,2,NOTHING"})
    void compareBaseballNumber(int number, int index, String resultType) {
        BaseballNumbers baseballNumbers = BaseballNumbers.of(1, 2, 3);
        assertThat(baseballNumbers.compareBaseballNumber(new BaseballNumber(number), index)).isEqualTo(ResultType.valueOf(resultType));
    }

    // TODO: 비교 테스트 합치기
    @DisplayName("야구번호세트 비교 테스트 - 3스트라이크")
    @Test
    void compareBaseballNumbers_3strike() {
        BaseballNumbers compare = BaseballNumbers.of(1, 2, 3);
        BaseballNumbers target = BaseballNumbers.of(1, 2, 3);
        assertThat(compare.compareBaseballNumbers(target)).containsExactly(MapEntry.entry(ResultType.STRIKE, 3));
    }

    @DisplayName("야구번호세트 비교 테스트 - 2스트라이크 1낫싱")
    @Test
    void compareBaseballNumbers_2strike_1nothing() {
        BaseballNumbers compare = BaseballNumbers.of(1, 2, 3);
        BaseballNumbers target = BaseballNumbers.of(1, 2, 4);
        assertThat(compare.compareBaseballNumbers(target)).contains(MapEntry.entry(ResultType.STRIKE, 2), MapEntry.entry(ResultType.NOTHING, 1));
    }

    @DisplayName("야구번호세트 비교 테스트 - 1스트라이크 1볼 1낫싱")
    @Test
    void compareBaseballNumbers_1strike_1ball_1nothing() {
        BaseballNumbers compare = BaseballNumbers.of(1, 2, 3);
        BaseballNumbers target = BaseballNumbers.of(1, 4, 2);
        assertThat(compare.compareBaseballNumbers(target)).contains(MapEntry.entry(ResultType.STRIKE, 1), MapEntry.entry(ResultType.BALL, 1), MapEntry.entry(ResultType.NOTHING, 1));
    }

}
