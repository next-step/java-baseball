import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringControllerTest {
    @Test
    void chopAt_IndexIs0to3_RestOfString() {
        assertThat(StringController.chopAt("abcd", 0)).isEqualTo("bcd");
        assertThat(StringController.chopAt("abcd", 1)).isEqualTo("acd");
        assertThat(StringController.chopAt("abcd", 2)).isEqualTo("abd");
        assertThat(StringController.chopAt("abcd", 3)).isEqualTo("abc");
    }
}
