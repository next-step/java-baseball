package game.baseball.domain.role;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class BasicPlayerTest {
    @Test
    @DisplayName("플레이어 : 숫자 입력 테스트")
    public void inputNumberTest() {
        // given
        Player player = new BasicPlayer();

        String expected = "123";
        InputStream in = new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // when
        String returnString = player.inputNumber();

        System.out.println("returnString = " + returnString);

        // then
        assertThat(returnString).isEqualTo(expected);
    }

}