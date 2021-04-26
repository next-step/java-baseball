import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.*;
import static org.assertj.core.api.Assertions.*;

class BaseballGameTest {
    BaseballGame baseballGame;
    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @DisplayName("랜덤숫자 생성 확인")
    @Test
    void createRandomNumber() {
        List<Integer> randomNumber1 = baseballGame.createRandomNumber();

        assertThat(randomNumber1).isNotEmpty()
                .doesNotContainNull()
                .hasSize(3);
    }

    @DisplayName("사용자 입력값 확인")
    @ParameterizedTest
    @CsvSource({"0, false", "123, true", "24, false", "'',false"})
    void validateUserNumber(String input, boolean expected) {
        boolean result = baseballGame.validateUserNumber(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사용자 입력값을 List<Integer> 변환 확인")
    @ParameterizedTest
    @CsvSource({"342,3,4,2", "436,4,3,6", "528,5,2,8"})
    void toIntegerList(String userNumber, int a, int b, int c) {
        List<Integer> number = baseballGame.toIntegerList(userNumber);
        assertThat(number).isNotEmpty()
                .doesNotContainNull()
                .containsSequence(a,b,c);
    }

    @DisplayName("null 값 List<Integer> 변환시 예외 확인")
    @Test
    void exception_toIntegerList() {
        String input = "";
        assertThatThrownBy(() -> {
            List<Integer> number = baseballGame.toIntegerList(input);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 0");
    }
}