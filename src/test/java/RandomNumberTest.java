import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {

    private RandomNumber randomNumber;

    @BeforeEach
    public void setUp() {
        randomNumber = RandomNumber.generate(10);
    }

    @Test
    public void testGenerate() {
        assertThat(randomNumber).isNotNull();
    }

    @Test
    public void testGet() {
        assertThatThrownBy(() -> randomNumber.get(10))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void testContain(String number) {
        assertThat(randomNumber.contain(number));
    }


}
