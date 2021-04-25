package baseball.domain.count;

import baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스트라이크 카운트를 테스트한다")
class StrikeTest {
    private Numbers randomNumbers = Numbers.valueOf("583");

    @DisplayName("스트라이크 카운트를 테스트한다")
    @ParameterizedTest
    @CsvSource(value = "835:0,891:0,524:1,853:1,593:2,583:3")
    void strikeCountTest(final String users, final int expected) {
        assertThat(new Ball().count(randomNumbers, Numbers.valueOf(users)))
                .isEqualTo(expected);
    }
}
