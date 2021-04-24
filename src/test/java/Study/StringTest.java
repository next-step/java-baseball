package Study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void splitStringTest(){
        // given
        String givenStr = "1,2";

        // when
        String[] result = givenStr.split(",");


        // then
        assertThat(new String[] {"1","2"}).contains(result);
        assertThat(new String[] {"1","2"}).containsExactly(result);
    }


    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splitStringTest2(){
        // given
        String givenStr = "1";

        // when
        String[] result = givenStr.split(",");


        // then
        assertThat(new String[] {"1","2"}).contains(result);
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splitStringTest3(){
        // given
        String givenStr = "1";

        // when
        String[] result = givenStr.split(",");


        // then
        assertThat(new String[] {"1","2"}).containsExactly(result);
    }


    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void substringStringTest(){
        // given
        String givenStr = "(1,2)";

        // when
        String result = givenStr.substring(1,givenStr.length()-1);


        // then
        assertThat("1,2").contains(result);
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    void charAtStringTestA(){
        // given
        String givenStr = "abc";

        // when
        char result = givenStr.charAt(0);


        // then
        assertThat('a').isEqualTo(result);
    }


    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void charAtStringIndexOutOfBoundsTest1(){
        // given
        String givenStr = "abc";

        assertThatThrownBy(() ->{
            char result = givenStr.charAt(givenStr.length());

        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + givenStr.length());

    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void charAtStringIndexOutOfBoundsTest2(){
        // given
        String givenStr = "abc";

        assertThatThrownBy(() ->{
            char result = givenStr.charAt(givenStr.length());

        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: "+givenStr.length()+", Size: "+givenStr.length());

    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void charAtStringIndexOutOfBoundsTest3(){
        // given
        String givenStr = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() ->{
                    char result = givenStr.charAt(givenStr.length());
                }).withMessageMatching("String index out of range: \\d+");

    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void charAtStringIndexOutOfBoundsTest4(){
        // given
        String givenStr = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() ->{
                    char result = givenStr.charAt(givenStr.length());
                }).withMessageMatching("Index: \\d+, Size: \\d+");

    }
}
