package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @Test
    @DisplayName("요구사항 1\n\"1,2\"을 ','로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void splitContains() {
        String initString = "1,2";
        String[] splitStringArr = initString.split(",");

        assertThat(splitStringArr).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1\n\"1\"을 ','로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    void splitContainsExactly() {
        String initString = "1";
        String[] splitStringArr = initString.split(",");

        assertThat(splitStringArr).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2\n\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 " +
            "\"()\"을 제거하고 \"1,2\"를 반환되는지에 대한 학습 테스트")
    void substring() {
        String initString = "(1,2)";
        String substring = initString.substring(1, 4);

        Assertions.assertEquals(substring, "1,2");
    }

    @ParameterizedTest
    @DisplayName("요구사항 3\n\"abc\"값이 주어졌을 때 String의 charAt() " +
            "메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    @CsvSource(value = {
            "0:a",
            "1:b",
            "2:c"
    }, delimiter = ':')
    void charAt(int index, char expected) {
        String initString = "abc";

        Assertions.assertEquals(initString.charAt(index), expected);
    }

    @Test
    @DisplayName("요구사항 3\nString의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 " +
            "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
    void stringIndexOutOfBoundsException() {
        String initString = "abc";
        int outOfIndex = initString.length() + 1;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> initString.charAt(outOfIndex)
        ).withMessageMatching("String index out of range: \\d+");
    }
}
