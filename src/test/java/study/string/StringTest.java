package study.string;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1-1 \"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void strDivideContains(){
        //given
        String str = "1,2";
        //when
        String[] strArr  = str.split(",");
        //then
        assertThat(strArr).contains("1","2");
    }

    @Test
    @DisplayName("요구사항1-2 \"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void strDivideContainsExactly(){
        //given
        String str = "1";
        //when
        String[] strArr  = str.split(",");
        //then
        assertThat(strArr).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    public void isSubStr(){
        //given
        String str = "(1,2)";
        //when
        String subStr = str.substring(1,4);
        //then
        assertThat("1,2").isEqualTo(subStr);

    }


    @ParameterizedTest
    @DisplayName("요구사항3-1\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다")
    @CsvSource(value = {"abc,0,a", "abc,1,b", "abc,2,c"})
    public void isCharAt(String str,int idx, char character){
        //when
        char charVal = str.charAt(idx);
        //then
       assertThat(character).isEqualTo(charVal);

    }

    @Test
    @DisplayName("요구사항3-2 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다")
    public void charException(){
        String str = "abc";
        assertThatThrownBy(() -> {
           str.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");
    }






}
