package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumberTest {

    @Test
    @DisplayName("야구번호 범위 1~9를 벗어나면 IllegalArgumentException를 리턴한다.")
    public void validationOverBaseballNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballNumber.of(10);
        });
    }

}