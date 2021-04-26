package camp.nextstep.edu.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "654", "978"})
    @DisplayName("BaseballNumber 객체 생성 - 성공 테스트")
    void of_successTest(String str) {
        // given & when
        BaseballNumber baseballNumber = BaseballNumber.of(str);

        // then
        assertThat(baseballNumber).isInstanceOf(BaseballNumber.class);
    }

    @Test
    @DisplayName("숫자 야구 게임 숫자 생성 - 성공 테스트")
    void generateBaseballNumber_successTest() {
        // given & when
        BaseballNumber baseballNumber = BaseballNumber.generateBaseballNumber();

        // then
        assertThat(baseballNumber).isInstanceOf(BaseballNumber.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "654", "978"})
    @DisplayName("숫자 야구 게임 입력 값 유효성 검사 - 성공 테스트")
    void isValidBaseballNumber_successTest(String str) {
        // given & when
        boolean result = BaseballNumber.isValidBaseballNumber(str);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "1234", "112"})
    @DisplayName("숫자 야구 게임 입력 값 유효성 검사 - 실패 테스트")
    void isValidBaseballNumber_failureTest(String str) {
        // given & when
        boolean result = BaseballNumber.isValidBaseballNumber(str);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "654", "978"})
    @DisplayName("숫자 야구 게임 반환 값 검사 - 성공 테스트")
    void compare_returnType_successTest(String str) {
        // given
        BaseballNumber target = BaseballNumber.generateBaseballNumber();
        BaseballNumber input = BaseballNumber.of(str);

        // when
        BaseballGameResult result = target.compare(input);

        // then
        assertThat(result).isInstanceOf(BaseballGameResult.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"234:0:2", "124:2:0", "123:3:0", "132:1:2", "456:0:0"}, delimiter = ':')
    @DisplayName("숫자 야구 게임 반환 값 검사 - 성공 테스트")
    void compare_baseballGameResult_successTest(String str, int strike, int ball) {
        // given
        BaseballNumber target = BaseballNumber.of("123");
        BaseballNumber input = BaseballNumber.of(str);

        // when
        BaseballGameResult result = target.compare(input);

        // then
        assertThat(result.getStrike()).isEqualTo(strike);
        assertThat(result.getBall()).isEqualTo(ball);
    }
}
