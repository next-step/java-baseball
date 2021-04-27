import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputNumberTest {

    private UserInputNumber userNumber;

    @BeforeEach
    public void setUp() {
        userNumber = new UserInputNumber();
    }

    @Test
    @DisplayName("3자리 숫자가 아닐때 에러 테스트")
    public void inputNumber() {
        assertThatThrownBy(() -> {
            userNumber.validation("1234");
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("3자리 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1:1", "1:1"}, delimiter = ':')
    @DisplayName("입력된 숫자 Int 형변환 테스트")
    public void charToInt(char input, int expected) {
        assertThat(userNumber.getInt(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("중복된 숫자가 있을 시 에러를 반환한다")
    public void doubleCheckInputTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        assertThatThrownBy(() -> {
            userNumber.doubleCheck(list);
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("중복된 숫자를 입력하였습니다.");
    }
}
