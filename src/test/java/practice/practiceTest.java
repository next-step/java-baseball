package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class practiceTest {

    @Test
    @DisplayName("String 요구사항 1 - \"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void String요구사항1_1(){
        String input = "1,2";
        String[] inputArr = input.split(",");
        assertThat(inputArr).contains("1","2");
    }
    @Test
    @DisplayName("String 요구사항 1 -  \"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void String요구사항1_2(){
        String input = "1";
        String[] inputArr = input.split(",");
        assertThat(inputArr).containsExactly("1");
    }

    @Test
    @DisplayName("String 요구사항 2 -  \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    public void String요구사항2(){
        String input = "(1,2)";
        String inputArr = input.substring(input.indexOf("(") +1, input.indexOf(")"));
        assertThat(inputArr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 요구사항 3 -  \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    public void String요구사항3(){
        String input = "abc";
        char[] inputArr = input.toCharArray();
        for(int i = 0 ; i < inputArr.length ; i ++){
            assertThat(input.charAt(i)).isEqualTo(inputArr[i]);
        }
    }
    @Test
    @DisplayName("String 요구사항 3 -  \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    public void String요구사항3_1(){
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

    }
    @Test
    @DisplayName("String 요구사항 3 -  \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    public void String요구사항3_2(){
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(4);
                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
    /*
        String Collection에 대한 학습 테스트 End
     */


    /*
        Set Collection에 대한 학습 테스트 Start
     */
    private Set<Integer> numbers ;

    @BeforeEach
    public void set(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
//        numbers.add(4);
//        numbers.add(4);
    }

    @DisplayName("set요구사항1 - Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    @Test
    public void set요구사항1(){
        assertThat(numbers.size()).isEqualTo(4);
    }

    @DisplayName("set요구사항2 - Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.")
    @Test
    public void set요구사항2(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
    @DisplayName("set요구사항2 - Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void set요구사항2_1(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("set요구사항3 - 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void set요구사항3(int number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
