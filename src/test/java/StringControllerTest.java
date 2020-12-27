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

    @Test
    void hasDuplicatedChar_LengthIslowerThen2_False() {
        assertThat(StringController.hasDuplicatedChar("")).isEqualTo(false);
        assertThat(StringController.hasDuplicatedChar("a")).isEqualTo(false);
        assertThat(StringController.hasDuplicatedChar("\t")).isEqualTo(false);
    }
    @Test
    void hasDuplicatedChar_IncludingDuplicatedChars_True() {
        assertThat(StringController.hasDuplicatedChar("aa")).isEqualTo(true);
        assertThat(StringController.hasDuplicatedChar("aba")).isEqualTo(true);
        assertThat(StringController.hasDuplicatedChar("abcdefgc")).isEqualTo(true);
    }
    @Test
    void hasDuplicatedChar_StringWithUniqueChars_False() {
        assertThat(StringController.hasDuplicatedChar("ab")).isEqualTo(false);
        assertThat(StringController.hasDuplicatedChar("abc")).isEqualTo(false);
        assertThat(StringController.hasDuplicatedChar("abcdefg")).isEqualTo(false);
    }
}
