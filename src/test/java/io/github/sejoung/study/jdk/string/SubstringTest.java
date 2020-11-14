package io.github.sejoung.study.jdk.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubstringTest {

    @DisplayName("괄호제거")
    @Test
    void substringTest() {
        String arg = "(1,2)";
        String result = arg.substring(arg.indexOf('(') + 1, arg.indexOf(')'));
        assertThat(result).isEqualTo("1,2");
    }
}
