package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuNumberTest {
    @Test
    void validateMenuTest() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new MenuNumber("3");
        });
    }
}
