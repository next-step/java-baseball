package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseballResultMessageTest {

    private BaseballResultMessage baseballResultMessage;

    @DisplayName("야구게임 결과 메세지 확인(strike, ball)")
    @Test
    void baseballResultMessage() {
        baseballResultMessage = new BaseballResultMessage(1, 1);

        assertThat(baseballResultMessage.getResultMessage().toString()).isEqualTo(" Strike: 1 Ball: 1");
        assertThat(baseballResultMessage.getStrikeCount()).isTrue();
    }

    @DisplayName("야구게임 결과 메세지 확인(Nothing)")
    @Test
    void baseballResultNothingMessage() {
        baseballResultMessage = new BaseballResultMessage(0, 0);

        assertThat(baseballResultMessage.getResultMessage().toString()).isEqualTo("Nothing");
        assertThat(baseballResultMessage.getStrikeCount()).isTrue();
    }

    @DisplayName("야구게임 결과 메세지 확인, Success 확인")
    @Test
    void baseballResultSuccessMessage() {
        baseballResultMessage = new BaseballResultMessage(3, 0);

        assertThat(baseballResultMessage.getResultMessage().toString()).isEqualTo(" Strike: 3");
        assertThat(baseballResultMessage.getStrikeCount()).isFalse();
    }
}