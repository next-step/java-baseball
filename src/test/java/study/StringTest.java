package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {


    // 요구사항 1
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    @Test
    public void splitString() {

        //input
        String str = "1,2";

        //split
        String[] splitStr = str.split(",");

        assertThat(splitStr).contains("1", "2");


    }

    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @Test
    public void splitStringArray() {

        //input
        String str = "1";

        //split
        String[] splitStr = str.split(",");

        assertThat(splitStr).containsExactly("1");


    }

    // 요구사항2
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    @Test
    public void subStringReturn() {

        //input
        String str = "(1,2)";

        //substring
        String subStr = str.substring(1, 4);

        Assertions.assertEquals(subStr, "1,2");


    }

    // 요구사항3
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현" +
            "\nString의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면\n" +
            "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.\n")
    @Test
    public void charAtStr() {

        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt('d'))
                .withMessageMatching("String index out of range: 100");
    }


}
