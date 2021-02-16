package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UserNumberTest {
    @Test
    void splitNumber() {
        UserNumber userNumber = new UserNumber("123");
        List<BaseballNumber> numbers = userNumber.getNumbers();

        List<BaseballNumber> targets = Arrays.asList(
                new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3));

        Assertions.assertThat(numbers).isEqualTo(targets);
    }

    @Test
    void validateNumber() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new UserNumber("113");
        });
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new UserNumber("13");
        });
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new UserNumber("abc");
        });
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new UserNumber("012");
        });
    }
}
