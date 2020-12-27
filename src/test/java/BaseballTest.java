import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;



public class BaseballTest {
    Baseball b = new Baseball();

    @Test
    void checkInputs(){
        assertThat(Baseball.isValidInput("1234")).isEqualTo(false);
        assertThat(Baseball.isValidInput("abc")).isEqualTo(false);
        assertThat(Baseball.isValidInput("1.2")).isEqualTo(false);
        assertThat(Baseball.isValidInput("123")).isEqualTo(true);
    }

    @Test
    void testStrikesCounter(){
        assertThat(Baseball.countStrikes("123", "234")).isEqualTo(0);
        assertThat(Baseball.countStrikes("123", "132")).isEqualTo(1);
        assertThat(Baseball.countStrikes("123", "124")).isEqualTo(2);
        assertThat(Baseball.countStrikes("123", "123")).isEqualTo(3);
    }
}
