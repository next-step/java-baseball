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

        assertThatThrownBy(() -> {
            searcher.findChar(inputText, 10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("찾는 index값이 문자길이 범위를 넘었습니다.");
    }

}
