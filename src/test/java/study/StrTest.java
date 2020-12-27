package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    public void isCorrectSecondCharOfString() {
        Str str = new Str("abc");
        char secondChar = str.charAt(1);
        assertThat(secondChar).isEqualTo('b');
    }

    @Test
    @DisplayName("When index passed as argument is bigger than string size should throw exception")
    public void charAtOutOfBounds() {
        Str str = new Str("abc");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}