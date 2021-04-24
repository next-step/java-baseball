package baseball;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import customtypes.Decision;

public class BaseballRefereeTest {

    private BaseballReferee baseballReferee;

    @BeforeEach
    void setup() {
        this.baseballReferee = new BaseballReferee();
    }

    @ParameterizedTest
    @CsvSource(value = {"123,STRIKE", "312,BALL", "456,NOTHING"})
    @DisplayName("결과 판정 - 플레이어가 입력한 숫자값 3개가 모두 같은 결과일 경우")
    void decide_succeed(String playerInput, Decision expected) {
        // given
        String computerInput = "123";

        // when
        List<Decision> decisions = this.baseballReferee.decide(playerInput.toCharArray(), computerInput);

        // then
        Assertions.assertThat(decisions.size()).isEqualTo(3);
        Assertions.assertThat(decisions).allMatch(d -> d == expected);
    }

    @Test
    @DisplayName("결과 판정 - 사용자가 134를 던지고 컴퓨터가 123을 던졌을 경우")
    void decide_succeed() {
        // given
        String playerInput = "134";
        String computerInput = "123";

        // when
        List<Decision> decisions = this.baseballReferee.decide(playerInput.toCharArray(), computerInput);

        // then
        Assertions.assertThat(decisions.size()).isEqualTo(3);
        Assertions.assertThat(decisions.get(0)).isEqualTo(Decision.STRIKE);
        Assertions.assertThat(decisions.get(1)).isEqualTo(Decision.BALL);
        Assertions.assertThat(decisions.get(2)).isEqualTo(Decision.NOTHING);
    }
}
