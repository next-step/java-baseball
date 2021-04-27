import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeNumberTest {

    @Test
    void checkNumberLength() {
        Assertions.assertThat(ThreeNumber.get().length()).isEqualTo(3);
    }

    @Test
    void checkNumber() {
        Assertions.assertThat(ThreeNumber.get().charAt(0) - '0').isBetween(1,9);
        Assertions.assertThat(ThreeNumber.get().charAt(1) - '0').isBetween(1,9);
        Assertions.assertThat(ThreeNumber.get().charAt(2) - '0').isBetween(1,9);
    }
}
