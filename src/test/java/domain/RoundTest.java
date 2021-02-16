package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RoundTest {
    @Test
    void setResult() {
        List<String> result = Arrays.asList("3스트라이크");
        Round round = new Round();
        round.setResult(result);

        Assertions.assertThat(round.isNot3Strike()).isFalse();
    }
}
