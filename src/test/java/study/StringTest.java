package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는가?")
    void require1to1() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는가?")
    void require1to2() {
        assertThat("1".split(",")).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환되는가?")
    void require2() {
        String requiredString = "(1,2)";
        assertThat(requiredString.substring(1, requiredString.length() - 1)).isEqualTo("1,2");
    }

    @Nested
    class Require3 {
        @Test
        @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는가?")
        void require1() {
            assertThat("abc".charAt(0)).isEqualTo('a');
        }

        @Test
        @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는가?")
        void require2() {
            assertThatThrownBy(() -> {
                "abc".charAt(10);
            }).isInstanceOf(StringIndexOutOfBoundsException.class);
        }
    }
}
