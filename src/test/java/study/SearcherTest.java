package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SearcherTest {

    private String inputText = "abc";

    @Test
    @DisplayName("문자를 찾는 테스트")
    void findCharSucceessTest() {
        Searcher searcher = new Searcher();
        assertThat(searcher.findChar(inputText, 0)).isEqualTo('a');
        assertThat(searcher.findChar(inputText, 1)).isEqualTo('b');
        assertThat(searcher.findChar(inputText, 2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자범위를 넘는 문자를 찾는 테스트")
    void findCharFailTest() {
        Searcher searcher = new Searcher();

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    searcher.findChar(inputText, 4);
                }).withMessageMatching("String index out of range: \\d+");

    }

}
