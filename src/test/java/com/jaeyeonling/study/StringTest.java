package com.jaeyeonling.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("String 클래스에 대해 테스트한다.")
class StringTest {

    @DisplayName("\"1,2\"을 `,` 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    @Test
    void doubleSplit() {
        // given
        final var input = "1,2";

        // when
        final var splitInput = input.split(",");

        // then
        assertThat(splitInput).contains("1", "2");
    }

    @DisplayName("\"1\"을 `,` 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @Test
    void singleSplit() {
        // given
        final var input = "1";

        // when
        final var splitInput = input.split(",");

        // then
        assertThat(splitInput).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환 하도록 구현한다.")
    @Test
    void substring() {
        // given
        final var input = "(1,2)";

        // when
        final var substringInput = input.substring(1, input.length() - 1);

        // then
        assertThat(substringInput).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @Test
    void charAt() {
        // given
        final var input = "abc";

        // when
        final var a = input.charAt(0);
        final var b = input.charAt(1);
        final var c = input.charAt(2);

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
        final var input = "abc";
        final var overIndex = input.length() + 1;

        // when / then
        assertThatThrownBy(() -> {
            final var ignored = input.charAt(overIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining(String.format("out of range: %d", overIndex));
    }
}
