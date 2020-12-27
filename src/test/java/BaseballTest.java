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

}
