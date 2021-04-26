package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName(value = "String 클래스 학습테스트")
public class StringTest {

    @Test
    @DisplayName(value =
            "\"1,2\"을 , 로 split 했을 때 " +
                    "1과 2로 잘 분리되는지 확인")
    void Requirements1_1(){
        assertThat("1,2".split(","))
                .contains("1")
                .contains("2");
    }

    @Test
    @DisplayName(value =
            "\"1\"을 , 로 split 했을 때 " +
                    "1만을 포함하는 배열이 반환되는지 확인")
    void Requirements1_2(){
        assertThat("1".split(","))
                .containsExactly("1");
    }

    @Test
    @DisplayName(value =
            "\"(1,2)\" 값이 주어졌을 때 " +
                    "String의 substring() 메소드를 활용해 () 을 제거하고 " +
                    "\"1,2\"를 반환되는지 확인")
    void Requirements2(){
        assertThat("1,2".substring(0,3))
                .contains("1")
                .contains("2");
    }

    @Test
    @DisplayName(value =
            "\"abc\" 값이 주어졌을 때 " +
                    "String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져옴")
    void Requirements3_1(){
        assertThat("abc".charAt(1))
                .isEqualTo('b');
    }

    @Test
    @DisplayName(value =
            "\"abc\" 값이 주어졌을 때 " +
                    "String의 charAt() 메소드를 활용해 특정 위치 값을 벗어나면 " +
                    "StringIndexOutOfBoundsException이 발생")
    void Requirements3_2(){
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
