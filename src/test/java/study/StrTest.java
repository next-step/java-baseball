package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrTest {
    @Test
    public void splitDelimiterComma() {
        Str str = new Str("1,2");
        String[] splitResult = str.split();
        assertThat(splitResult).containsExactly("1", "2");
    }

    @Test
    public void splitSingleElement() {
        Str str = new Str("1");
        String[] splitResult = str.split();
        assertThat(splitResult).containsExactly("1");
    }

    @Test
    public void removeBothSidesParenthesis() {
        Str str = new Str("(1,2)");
        String removeResult = str.removeParenthesis();
        assertThat(removeResult).isEqualTo("1,2");
    }
}