package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserNumberTest {
    @Test
    void validateNumberTest() {
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
