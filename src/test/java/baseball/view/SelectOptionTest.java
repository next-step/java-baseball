package baseball.view;

import baseball.domain.Baseball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectOptionTest {

    @Test
    @DisplayName("restart test")
    public void restart() {
        SelectOption restart = SelectOption.of("1");
        assertThat(restart.isRestart()).isEqualTo(true);
    }

    @Test
    @DisplayName("stop test")
    public void stop() {
        SelectOption restart = SelectOption.of("2");
        assertThat(restart.isRestart()).isEqualTo(false);
    }

    @Test
    @DisplayName("IllegalArgumentException test 1")
    public void abnormalInputStringNum() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SelectOption.of("3");
        });

    }

    @Test
    @DisplayName("IllegalArgumentException test 2")
    public void abnormalInputChar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SelectOption.of("g");
        });
    }
}
