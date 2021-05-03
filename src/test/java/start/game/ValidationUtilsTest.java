package start.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @Test
    @DisplayName("야구 숫자  1 ~ 9 검증")
    public void isInOneToNightNumberTest(){
        assertThat(ValidationUtils.isInOneToNightNumber(9)).isTrue();
        assertThat(ValidationUtils.isInOneToNightNumber(1)).isTrue();
        assertThat(ValidationUtils.isInOneToNightNumber(3)).isTrue();
        assertThat(ValidationUtils.isInOneToNightNumber(0)).isFalse();
        assertThat(ValidationUtils.isInOneToNightNumber(10)).isFalse();
    };


}
