import baseBall.util.Discrimination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscriminationTest {

    private Discrimination discrimination = new Discrimination();



    @DisplayName("위치와 숫자가 일치하는 경우 스트라이크 판정 테스트")
    @ParameterizedTest
    @CsvSource(value = {"124 : 2"}, delimiter = ':')
    public void discriminationStrikeTest(String systemNumber, String userNumber) {
        assertThat(discrimination.getStrikeCount(systemNumber, userNumber, 1)).isEqualTo(1);
    }

    @DisplayName("위치는 다르지만 숫자가 일치하는 경우 스트라이크 판정 테스트")
    @ParameterizedTest
    @CsvSource(value = {"124 : 1"}, delimiter = ':')
    public void discriminationBallTest(String systemNumber, String userNumber) {
        assertThat(discrimination.getBallCount(systemNumber, userNumber, 1)).isEqualTo(1);
    }
}
