import domain.Number;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @Test
    void create() {
       Number number = Number.of(1);
       assertThat(number).isEqualTo(Number.of(1));
    }
}
