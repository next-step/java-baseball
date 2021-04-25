import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballRulesTest {
    private BaseballRules rules = new BaseballRules();

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5000})
    @DisplayName("createRandomNumbers의 매개변수값이 1이상 입력되지 않았을때 exception 처리.")
    void createRandomNumbers_lessThan1(int size) {
        assertThatThrownBy(() -> {rules.createRandomNumbers(size);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.LESS_THAN_1.getText());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("createRandomNumbers의 매개변수로 전달할 값 만큼 Array 사이즈를 생성하는지 확인..")
    void createRandomNumbers_sizeTest(int size) {
        assertThat(rules.createRandomNumbers(size))
            .hasSize(size);
    }


}
