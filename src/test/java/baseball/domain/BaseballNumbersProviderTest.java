package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("야구게임 숫자 생성 테스트")
class BaseballNumbersProviderTest {

    @DisplayName("1이상 9이하의 서로 다른 정수로 구성된 3자리 수를 생성함")
    @Test
    void 야구게임_숫자_생성_테스트() {
        // when
        BaseballNumbers baseballNumbers = BaseballNumbersProvider.provideBaseballNumbers();
        // then
        assertThat(baseballNumbers.getSize()).isEqualTo(3);
    }
}