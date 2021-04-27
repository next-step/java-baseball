package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * String 클래스에 대한 학습 테스트
 */
public class StringTest {


    /**
     * 요구사항 1.
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리 되는지 확인하는 학습 테스트.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트.
     */
    @Test
    public void checkSplitValue(){
        String[] strArry = "1,".split(",");
        assertThat(strArry).contains("1");
        assertThat(strArry).containsExactly("1");
    }

    /**
     * 요구사항 2.
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()를 제거 하고 "1,2"를 반환
     */
    @Test
    public void substringRoundBrackets(){
        String str = "(1,2)";
        assertThat(str.substring(1,4)).isEqualTo("1,2");
    }

    /**
     * 'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트
     */
    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습")
    void charTest() {
        String str = "abc";
        int index = 5;

        assertThatThrownBy(() -> {str.charAt(index);})
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
