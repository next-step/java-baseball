import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class SplitStringUtilTest {
    @DisplayName("숫자 하나 split 테스트")
    @Test
    void testsplitDigitNumberOne(){
        SplitStringUtil splitStringUtil = new SplitStringUtil();
        assertThat(splitStringUtil.splitDigitNumber("1")).contains(1);
    }

    @DisplayName("숫자 리스트 split 테스트")
    @Test
    void testsplitDigitNumberList(){
        SplitStringUtil splitStringUtil = new SplitStringUtil();
        assertThat(splitStringUtil.splitDigitNumber("1,2")).containsExactly(1,2);
    }

    @DisplayName("괄호 제거 Substring 테스트")
    @Test
    void testSubStringText(){
        SplitStringUtil splitStringUtil = new SplitStringUtil();
        assertThat(splitStringUtil.subStringText("(1,2)")).isEqualTo("1,2");
    }

    @DisplayName("특정 문자 위치 구하기 함수 테스트 및 StringIndexOutOfBoundsException 테스트")
    @Test
    void testGetCharLocation(){
        SplitStringUtil splitStringUtil = new SplitStringUtil();
        assertThat(splitStringUtil.getCharLocation("abc",2)).isEqualTo('c');
    }

    @DisplayName("특정 문자 위치 구하기 함수의 StringIndexOutOfBoundsException 테스트")
    @Test
    void testGetCharLocationException(){
        SplitStringUtil splitStringUtil = new SplitStringUtil();
        assertThatThrownBy(() -> splitStringUtil.getCharLocation("abc",5)).
                isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageStartingWith("Index: 2, Size: 2");
    }

}