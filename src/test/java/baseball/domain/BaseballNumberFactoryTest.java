package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseballNumberFactoryTest {

    @Test
    @DisplayName("null 파라미터 입력")
    void create_inputNull() {
        // given
        BaseballNumberFactory factory = new BaseballNumberFactory();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.generateBaseballNumbers(() -> null))
                .withMessageMatching("숫자 정보를 입력해 주세요.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열 기반 생성 - null 또는 공백입력")
    void create_nullOrEmpty(String param) {
        // given
        BaseballNumberFactory factory = new BaseballNumberFactory();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.generateBaseballNumbers(param))
                .withMessageMatching("숫자 정보를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234"})
    @DisplayName("사이즈 부적합")
    void create_invalidSize(String param) {
        // given
        BaseballNumberFactory factory = new BaseballNumberFactory();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.generateBaseballNumbers(param))
                .withMessageMatching("숫자는 3 개로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("빈 사이즈 리스트 입력")
    void create_inputEmpty() {
        // given
        BaseballNumberFactory factory = new BaseballNumberFactory();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.generateBaseballNumbers(ArrayList::new))
                .withMessageMatching("숫자는 3 개로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("숫자 사이즈 초과")
    void create_greaterThanMaxSize() {
        // given
        BaseballNumberFactory factory = new BaseballNumberFactory();
        List<Integer> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(1);
        baseballNumbers.add(2);
        baseballNumbers.add(3);
        baseballNumbers.add(4);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.generateBaseballNumbers(() -> baseballNumbers))
                .withMessageMatching("숫자는 3 개로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("숫자 중복입력 불가")
    void create_DuplicateNumbers() {
        // given
        BaseballNumberFactory factory = new BaseballNumberFactory();
        List<Integer> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(1);
        baseballNumbers.add(1);
        baseballNumbers.add(2);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.generateBaseballNumbers(() -> baseballNumbers))
                .withMessageMatching("중복된 숫자가 존재합니다. 입력값을 확인해 주세요.");
    }

    @Test
    @DisplayName("문자열 기반 생성 - 숫자 중복입력 불가")
    void create_DuplicateNumbers_byString() {
        // given
        BaseballNumberFactory factory = new BaseballNumberFactory();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.generateBaseballNumbers("112"))
                .withMessageMatching("중복된 숫자가 존재합니다. 입력값을 확인해 주세요.");
    }

    @Test
    @DisplayName("문자열 입력")
    void create_nonNumeric() {
        // given
        BaseballNumberFactory factory = new BaseballNumberFactory();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.generateBaseballNumbers("임동섭"))
                .withMessageMatching("숫자를 입력해 주세요.");
    }
}