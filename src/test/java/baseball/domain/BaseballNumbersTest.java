package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseballNumbersTest {

    @Test
    @DisplayName("null 파라미터 입력")
    void create_inputNull() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(() -> null))
                .withMessageMatching("숫자 정보를 입력해 주세요.");
    }

    @Test
    @DisplayName("빈 사이즈 리스트 입력")
    void create_inputEmpty() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(new ArrayList<>()))
                .withMessageMatching("숫자는 3 개로 이루어져야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(ArrayList::new))
                .withMessageMatching("숫자는 3 개로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("숫자 사이즈 초과")
    void create_greaterThanMaxSize() {
        // given
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(new BaseballNumber(1));
        baseballNumbers.add(new BaseballNumber(2));
        baseballNumbers.add(new BaseballNumber(3));
        baseballNumbers.add(new BaseballNumber(4));

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(baseballNumbers))
                .withMessageMatching("숫자는 3 개로 이루어져야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(() -> {
                    List<Integer> strategyResult = new ArrayList<>();
                    strategyResult.add(1);
                    strategyResult.add(2);
                    strategyResult.add(3);
                    strategyResult.add(4);
                    return strategyResult;
                }))
                .withMessageMatching("숫자는 3 개로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("숫자 중복입력 불가")
    void create_DuplicateNumbers() {
        // given
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(new BaseballNumber(1));
        baseballNumbers.add(new BaseballNumber(1));
        baseballNumbers.add(new BaseballNumber(2));

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(baseballNumbers))
                .withMessageMatching("중복된 숫자가 존재합니다. 입력값을 확인해 주세요.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(() -> {
                    List<Integer> strategyResult = new ArrayList<>();
                    strategyResult.add(1);
                    strategyResult.add(1);
                    strategyResult.add(2);
                    return strategyResult;
                }))
                .withMessageMatching("중복된 숫자가 존재합니다. 입력값을 확인해 주세요.");
    }

}