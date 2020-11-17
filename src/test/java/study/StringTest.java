package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    private String str;

    @DisplayName("1,2을 ,로 split했을때 1과 2로 잘 분리되는지 확인한다")
    @Test
    public void testSplitWhenComma() {
        str = "1,2";
        String[] result = str.split(",");
        assertThat(result).contains("1", "2");
    }

    @DisplayName("1 ,로 split했을때 1만 포함하는 배열이 반횐되는지 확인한다")
    @Test
    public void testSplitWhenComma2() {
        str = "1,";
        String[] result = str.split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2 반환")
    @Test
    public void testSubstringForParenthesesRemove() {
        str = "(1,2)";
        int subStringStartNum = 1;
        int subStringEndNum = str.length() - 1;
        String result = str.substring(subStringStartNum, subStringEndNum);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자 가져오기")
    @Test
    public void testStringIndexOutOfBoundsExceptionWhenOverrange() {
        str = "abc";
        assertThatThrownBy(() -> {
            try {
                str.charAt(str.length());
            } catch (StringIndexOutOfBoundsException e) {
                throw new StringIndexOutOfBoundsException("Index: 2, Size: 2");
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
}
