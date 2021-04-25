package baseball.domain.count;

import baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("볼 카운트를 테스트한다")
class BallTest {
    private Numbers randomNumbers = Numbers.valueOf("5", "8", "3");

    @DisplayName("볼 카운트를 테스트한다")
    @ParameterizedTest
    @CsvSource(value = "123:0,523:0,583:0,891:1,853:2,916:3")
    void ballCountTest(final String users, final int expected) {
        assertThat(new Ball().count(randomNumbers, Numbers.valueOf(users)))
                .isEqualTo(expected);
    }
}
