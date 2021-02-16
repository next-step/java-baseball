package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoundResultTest {
    @Test
    void getResult() {
        List<BaseballNumber> userNumber = Arrays.asList(new BaseballNumber(1),
                new BaseballNumber(2), new BaseballNumber(3)); // 123
        List<BaseballNumber> computer = Arrays.asList(new BaseballNumber(1),
                new BaseballNumber(2), new BaseballNumber(3)); // 123
        RoundResult roundResult = new RoundResult(userNumber, computer);
        List<String> result = roundResult.getResult();
        List<String> target = Collections.singletonList("3스트라이크");

        Assertions.assertThat(result).isEqualTo(target);

        userNumber = Arrays.asList(new BaseballNumber(1),
                new BaseballNumber(3), new BaseballNumber(4)); // 134
        roundResult = new RoundResult(userNumber, computer);
        result = roundResult.getResult();
        target = Arrays.asList("1볼", "1스트라이크");

        Assertions.assertThat(result).isEqualTo(target);

    }
}
