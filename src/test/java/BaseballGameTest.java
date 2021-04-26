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
}