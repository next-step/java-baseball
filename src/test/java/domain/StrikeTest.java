package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeTest {

    @DisplayName("STRIKE 3개 숫자 모두 일치 테스트")
    @Test
    void strike_all_matching_test() {

        // given
        int matchingCount = 3;
        Strike strike = new Strike(matchingCount);

        // when & then
        assertThat(strike.isAllMatching()).isTrue();
    }

    @DisplayName("STRIKE 일부 숫자 일치 테스트")
    @Test
    void strike_exist_matching_test() {

        // given
        int matchingCount = 2;
        Strike strike = new Strike(matchingCount);

        // when & then
        assertThat(strike.isExistMatching()).isTrue();
    }

}
