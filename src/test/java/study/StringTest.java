package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringTest {

    @DisplayName("문자열 분리(구분자: ',')")
    @Test
    void doubleSplit() {
        // given
        String input = "1,2";

        // when
        String[] splitInput = input.split(",");

        // then
        assertThat(splitInput).contains("1", "2");
    }

    @DisplayName("문자열 맨앞, 맨뒤 괄호제거")
    @Test
    void singleSplit() {
        // given
        String input = "1";

        // when
        String[] splitInput = input.split(",");

        // then
        assertThat(splitInput).containsExactly("1");
    }

    @DisplayName("charAt 인덱스 범위(메세지 매칭)")
    @Test
    void substring() {
        // given
        String input = "(1,2)";

        // when
        String substringInput = input.substring(1, input.length() - 1);

        // then
        assertThat(substringInput).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @Test
    void charAt() {
        // given
        String input = "abc";

        // when
        char a = input.charAt(0);
        char b = input.charAt(1);
        char c = input.charAt(2);

        // then
        assertAll(() -> assertThat(a).isEqualTo('a'),
                () -> assertThat(b).isEqualTo('b'),
                () -> assertThat(c).isEqualTo('c'));
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 " +
            "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    @Test
    void charAtOutOfBounds() {
        // given
        String input = "abc";
        int overIndex = input.length() + 1;

        // when / then
        assertThatThrownBy(() -> {
            char ignored = input.charAt(overIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining(String.format("out of range: %d", overIndex));
    }
}
