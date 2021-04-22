package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void testSplit() {
        //given
        final String given = "1,2";
        //when
        String[] result = given.split(",");
        //then
        assertThat(result).contains("1").contains("2");
    }

    @Test
    public void testSplitNoSplitElementCase() {
        //given
        final String given = "1";
        //when
        String[] result = given.split(",");
        //then
        assertThat(result).containsExactly("1");
    }

    @Test
    public void testSubstring() {
        //given
        final String given = "(1,2)";
        //when
        String result = given.substring(1, given.length() - 1);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName(value = "charAt(index) 테스트")
    public void testCharAt() {
        //given
        final String given = "abc";
        final int index = 1;
        //when
        char result = given.charAt(index);
        //then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName(value = "charAt() 테스트 실패 케이스 메서드의 문자 범위를 벗어난 경우 StringIndexOutOfBoundsException 발생 테스트")
    public void testCharAtFailCaseIndexOutBound() {
        //given
        final String given = "abc";
        final int index = given.length();
        //when, then
        assertThatThrownBy(() -> given.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
