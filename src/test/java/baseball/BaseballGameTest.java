package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로직 테스트")
public class BaseballGameTest {
    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        this.baseballGame = new BaseballGame();
    }

    @ParameterizedTest
    @DisplayName("플레이어가 입력한 숫자 검증 - 정상 입력한 경우")
    @ValueSource(ints = {123, 692})
    void validNumberPassTest(int number) {
        assertThat(baseballGame.confirmNumber(number));
    }

    @ParameterizedTest
    @DisplayName("플레이어가 입력한 숫자 검증 - 잘못 입력한 경우")
    @ValueSource(ints = {444, 2512, 5})
    void validNumberFailTest(int number) {
        assertThat(baseballGame.confirmNumber(number).isEmpty())
                .isTrue();
    }
}
