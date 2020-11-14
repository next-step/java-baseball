import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UITest {
    @Test
    public void testValidate() {
        assertThat(UI.validate("123")).isTrue();
        assertThat(UI.validate("999")).isFalse();
        assertThat(UI.validate("121")).isFalse();
        assertThat(UI.validate("1234")).isFalse();
        assertThat(UI.validate("a12")).isFalse();
    }
}