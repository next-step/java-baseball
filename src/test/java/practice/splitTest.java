package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class splitTest {

    @Test
    @DisplayName("String 요구사항 1 - \"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void 요구사항1_1(){
        String input = "1,2";
        String[] inputArr = input.split(",");
        assertThat(inputArr).contains("1","2");
    }
    @Test
    @DisplayName("String 요구사항 1 -  \"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void 요구사항1_2(){
        String input = "1";
        String[] inputArr = input.split(",");
        assertThat(inputArr).containsExactly("1");
    }

    @Test
    @DisplayName("String 요구사항 2 -  \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    public void 요구사항2(){
        String input = "(1,2)";
        String inputArr = input.substring(input.indexOf("(") +1, input.indexOf(")"));
        assertThat(inputArr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 요구사항 3 -  \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    public void 요구사항3(){
        String input = "abc";
        char[] inputArr = input.toCharArray();
        for(int i = 0 ; i < inputArr.length ; i ++){
            assertThat(input.charAt(i)).isEqualTo(inputArr[i]);
        }
    }
    @Test
    @DisplayName("String 요구사항 3 -  \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    public void 요구사항3_1(){
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

    }
    @Test
    @DisplayName("String 요구사항 3 -  \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    public void 요구사항3_2(){
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(4);
                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }



}
